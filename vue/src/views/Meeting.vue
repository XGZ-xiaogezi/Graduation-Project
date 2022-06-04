<template>
  <div>
    <div style="font-size: 20px;color: #409EFF;margin-top: 100px">会议列表</div>
    <template>
      <el-table :data="tableData" border stripe style="margin-top: 30px" size="medium">
        <el-table-column prop="id" label="ID" width="80"></el-table-column>
        <el-table-column prop="title" label="会议主题" align="center"></el-table-column>
        <el-table-column prop="loc" label="会议地点" align="center"></el-table-column>
        <el-table-column prop="time" label="会议时间" align="center"></el-table-column>
        <el-table-column prop="emps[0].ename" label="发起人" align="center"></el-table-column>
        <el-table-column prop="status" label="状态" align="center"></el-table-column>
      </el-table>
    </template>
  </div>
</template>

<script>
import moment from "moment";

export default {
  name: "Meeting",
  data(){
    return{
      tableData:[],
      emp: localStorage.getItem("emp") ? JSON.parse(localStorage.getItem("emp")) : {}
    }
  },
  created() {
    this.load()
  },
  methods: {
    load(){
      this.request.get('/meeting/getMeeting',{
        params:{
          empno: this.emp.empno
        }
      }).then(res => {
        this.tableData = res.data
        //遍历res.data
        this.tableData.forEach(item => {
          if (item.time<moment().format('YYYY-MM-DD HH:mm:ss')){
            item.status = '已结束'
        }else {
            item.status = '待开会'
          }}
          )
      })
    }
  }
}
</script>

<style scoped>

</style>