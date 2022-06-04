<template>
<div>
  <div style="margin-bottom: 30px;font-size: 20px;color: #67C23A">发起请假</div>
  <el-form :inline="true" :model="formInline" class="demo-form-inline" size="medium">
    <el-form-item label="请假时间">
      <el-col :span="11">
        <el-date-picker type="date" placeholder="选择日期" v-model="formInline.createTime" style="width: 100%;"></el-date-picker>
      </el-col>
      <el-col class="line" :span="2">&nbsp;&nbsp;&nbsp;&nbsp;-</el-col>
      <el-col :span="11">
        <el-date-picker type="date" placeholder="选择日期" v-model="formInline.endTime" style="width: 100%;"></el-date-picker>
      </el-col>
    </el-form-item>
    <el-form-item label="详细描述">
      <el-input type="textarea" v-model="formInline.desc"></el-input>
    </el-form-item>
    <el-form-item>
      <el-button type="primary" @click="onSubmit">立即创建</el-button>
      <el-button @click="reset">取消</el-button>
    </el-form-item>
  </el-form>
  <div style="font-size: 20px;color: #409EFF;margin-top: 100px">审核状态</div>
  <el-table :data="tableData" border stripe style="margin-top: 60px" size="medium">
    <el-table-column prop="id" label="ID" width="80"></el-table-column>
    <el-table-column prop="description" label="详细描述" align="center" width="500px"></el-table-column>
    <el-table-column prop="createTime" label="请假开始时间" align="center"></el-table-column>
    <el-table-column prop="endTime" label="请假结束时间" align="center"></el-table-column>
    <el-table-column prop="isAbled" label="审核状态" align="center"></el-table-column>
  </el-table>
  <div style="padding: 10px 0">
    <el-pagination
        @size-change="handleSizeChange"
        @current-change="handleCurrentChange"
        :current-page="pageNum"
        :page-sizes="[2, 5, 10, 20]"
        :page-size="pageSize"
        layout="total, sizes, prev, pager, next, jumper"
        :total="total">
    </el-pagination>
  </div>
</div>
</template>

<script>
export default {
  name: "Qj",
  data() {
    return {
      formInline: {
        createTime: '',
        endTime: '',
        desc: '',
      },
      tableData: [],
      total: 0,
      pageNum: 1,
      pageSize: 2,
      emp: localStorage.getItem("emp") ? JSON.parse(localStorage.getItem("emp")) : {}
    }
  },
  created() {
    this.load()
  },
  methods: {
    load(){
      this.request.get("/qj/page",{
        params:{
          empno: this.emp.empno,
          pageNum: this.pageNum,
          pageSize: this.pageSize,
        }
      }).then(res =>{
        this.tableData = res.data.records
        this.total = res.data.total
        this.tableData.forEach(item => {
          item.createTime = item.createTime.substring(0,10)
          item.endTime = item.endTime.substring(0,10)
          if (item.isAbled == 0){
            item.isAbled = "审核中"
          }else if (item.isAbled == 1){
            item.isAbled = "已通过"
        }else if (item.isAbled == 2){
            item.isAbled = "未通过"
        }
        })
      })
    },
    onSubmit() {
      //creatTime<=endTime
      if (this.formInline.createTime > this.formInline.endTime){
        this.$message({
          message: '请假开始时间不能大于结束时间',
          type: 'warning'
        });
        return
      }
      this.request.get("/qj/addQj", {
        params:{
          empno: this.emp.empno,
          ename: this.emp.ename,
          deptno: this.emp.deptno,
          createTime: this.formInline.createTime,
          endTime: this.formInline.endTime,
          description: this.formInline.desc,
        }
      }).then(res =>{
        if (res.code === "200"){
          this.formInline = {}
          this.$message.success("提交成功")
          this.load()
        }
      })
    },
    handleSizeChange(pageSize) {
      console.log(pageSize)
      this.pageSize = pageSize
      this.load()
    },
    handleCurrentChange(pageNum) {
      console.log(pageNum)
      this.pageNum = pageNum
      this.load()
    },
    reset() {
      this.formInline = {}
    }
  }
}
</script>

<style scoped>

</style>