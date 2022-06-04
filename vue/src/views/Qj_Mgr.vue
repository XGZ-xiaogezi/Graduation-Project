<template>
  <div>
    <div style="font-size: 20px;color: #409EFF;margin-top: 10px">部门请假审批</div>
    <el-table :data="tableData" border stripe :header-cell-class-name="'headerBg'"  @selection-change="handleSelectionChange" style="margin-top: 50px">
      <el-table-column type="selection" width="55" align="center"></el-table-column>
      <el-table-column prop="id" label="id" width="80" align="center"></el-table-column>
      <el-table-column prop="empno" label="员工编号" width="80" align="center"></el-table-column>
      <el-table-column prop="ename" label="用户名" width="80" align="center"></el-table-column>
      <el-table-column prop="createTime" label="开始时间" width="120" align="center"></el-table-column>
      <el-table-column prop="endTime" label="结束时间" align="center" width="120"></el-table-column>
      <el-table-column prop="description" label="描述" align="center"></el-table-column>
      <el-table-column label="审批"  width="200" align="center">
        <template slot-scope="scope">
          <el-button type="success" icon="el-icon-check" circle @click="pass(scope.row.id)"></el-button>
          <el-popconfirm
              class="ml-5"
              confirm-button-text='确定'
              cancel-button-text='我再想想'
              icon="el-icon-info"
              icon-color="red"
              title="您确定不通过吗？"
              @confirm="unpass(scope.row.id)"
          >
            <el-button type="danger" icon="el-icon-close" slot="reference" circle></el-button>
          </el-popconfirm>
        </template>
      </el-table-column>
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
  name: "Qj_Mgr",
  data(){
    return {
      tableData: [],
      pageNum: 1,
      pageSize: 10,
      total: 0,
      emp: localStorage.getItem("emp") ? JSON.parse(localStorage.getItem("emp")) : {}
    }
  },
  created() {
    this.load()
  },
  methods:{
    load() {
      this.request.get("/qj/getQjbyDeptno", {
        params: {
          deptno: this.emp.deptno,
          pageNum: this.pageNum,
          pageSize: this.pageSize,
        }
      }).then(res => {
        this.tableData = res.data.records
        this.total = res.data.total
      })
    },
    handleSizeChange(pageSize) {
      this.pageSize = pageSize
      this.load()
    },
    handleCurrentChange(pageNum) {
      this.pageNum = pageNum
      this.load()
    },
    handleSelectionChange(val) {
      this.multipleSelection = val
    },
    pass(id){
      this.request.get("/qj/pass", {
        params: {
          id: id
        }
      }).then(res => {
        this.$message.success("审批成功")
        this.load()
      })
    },
    unpass(id){
      this.request.get("/qj/unpass", {
        params: {
          id: id
        }
      }).then(res => {
        this.$message.success("审批成功")
        this.load()
      })
    },
  },
}
</script>

<style scoped>

</style>