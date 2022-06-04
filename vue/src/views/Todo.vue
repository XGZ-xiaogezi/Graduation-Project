<template>
<div>
  <div style="font-size: 20px;color: #409EFF;margin-top: 50px">待完成任务列表</div>
  <el-table :data="tableData" border stripe style="margin-top: 60px" size="medium">
    <el-table-column prop="id" label="ID" width="80"></el-table-column>
    <el-table-column prop="body" label="工作内容" width="500px" align="center"></el-table-column>
    <el-table-column prop="createTime" label="发布时间" align="center"></el-table-column>
    <el-table-column prop="lastTime" label="截止时间" align="center"></el-table-column>
    <el-table-column prop="createId" label="发布人" align="center"></el-table-column>
    <el-table-column label="操作"  width="200" align="center">
      <template slot-scope="scope">
        <el-popconfirm
            class="ml-5"
            confirm-button-text='确定'
            cancel-button-text='我再想想'
            icon="el-icon-info"
            icon-color="red"
            title="您确定已完成吗？"
            @confirm="updateTodo(scope.row.id)"
        >
          <el-button type="success" slot="reference" round>点击确认完成</el-button>
        </el-popconfirm>
      </template>
    </el-table-column>
  </el-table>
  <div style="padding: 10px 0">
    <el-pagination
        @size-change="handleSizeChange"
        @current-change="handleCurrentChange"
        :current-page="pageNum"
        :page-sizes="[5, 10, 20]"
        :page-size="pageSize"
        layout="total, sizes, prev, pager, next, jumper"
        :total="total">
    </el-pagination>
  </div>

</div>
</template>

<script>
export default {
  name: "Todo",
  data(){
    return{
      tableData: [],
      total: 0,
      pageNum: 1,
      pageSize: 5,
      emp: localStorage.getItem("emp") ? JSON.parse(localStorage.getItem("emp")) : {}
    }
  },
  created() {
    this.load()
  },
  methods:{
    load(){
      this.request.get("/todo/page", {
        params: {
          pageNum: this.pageNum,
          pageSize: this.pageSize,
          empno: this.emp.empno
        }
      }).then(res => {
        this.tableData = res.data.records
        this.total = res.data.total
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
    updateTodo(id){
      this.request.get("/todo/updateTodo",{
        params:{
          empno:this.emp.empno,
          id:id
        }
      }).then(res =>{
          if (res.code === "200"){
            this.$message.success("提交成功")
            this.load()
          }else {
            this.$message.error("系统异常")
          }
      })
    }
  }
}
</script>

<style scoped>

</style>