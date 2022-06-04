<template>
  <el-calendar :first-day-of-week="7">
    <template slot="dateCell" slot-scope="{ data }">
      <p>{{ data.day.split("-").slice(2).join("-") }}<br/></p>
      <div
          v-for="(item, index) in calendarData"
          :key="index"
      >
        <div v-if="data.day == item.time" style="color: #67C23A">
          <i class="el-icon-check" v-if="item.status === 1"></i>
        </div>
      </div>
    </template>
  </el-calendar>
</template>

<script>
export default {
  name: "Dk",
  data(){
    return{
      calendarData: [],
      emp: localStorage.getItem("emp") ? JSON.parse(localStorage.getItem("emp")) : {}
    }
  },
  created() {
    this.load()
    console.log(this.emp)
  },
  methods:{
    load(){
      this.request.get("/dk/get",{
        params:{
          empno: this.emp.empno
        }
      }).then(res =>{
        this.calendarData = res.data
      })
    }
  }
}
</script>

<style scoped>

</style>