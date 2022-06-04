<template>
  <div>
    <div style="position: relative;top: 120px">
      <el-row>
      <el-col :span="12" v-if="flag === true">
        <el-result icon="success" title="今日已打卡" subTitle="开始一天愉快的工作吧！">
        </el-result>
      </el-col>
      <el-col :span="12" v-if="flag === false">
        <el-result icon="info" title="今日还未打卡" subTitle="点击打卡！">
          <template slot="extra">
            <el-button type="primary" size="medium" @click="addDk()">打卡</el-button>
          </template>
        </el-result>
      </el-col>
      <el-col :span="12">
        <div id="pie" style="width: 500px; height: 400px"></div>
      </el-col>
      </el-row>
    </div>
  </div>
</template>

<script>
import moment from "moment";
import * as echarts from "echarts";
export default {
  name: "Home",
  data(){
    return{
      flag:"",
      emp: localStorage.getItem("emp") ? JSON.parse(localStorage.getItem("emp")) : {}
    }
  },
  created() {
    this.load()
    // console.log(moment().startOf("day").format("yyyy-MM-D HH:mm:ss"))
    // console.log(JSON.parse(localStorage.getItem("emp")).empno)
  },
  methods:{
    load(){
      this.request.get("/dk/find",{
        params: {
          empno : JSON.parse(localStorage.getItem("emp")).empno,
          start : moment().startOf("day").format("yyyy-MM-D HH:mm:ss"),
          end : moment().endOf("day").format("yyyy-MM-D HH:mm:ss")
        }
      }).then(res =>{
        if(res.code === "500"){
          this.flag = false
        }else {
          this.flag = true
        }
      })
    },
    addDk(){
      this.request.get("/dk/addDk",{
        params:{
          empno : JSON.parse(localStorage.getItem("emp")).empno,
          time : moment().format("yyyy-MM-D HH:mm:ss"),
        }
      }).then(res => {
        if (res.code === "200"){
          this.flag = true
          this.$message.success("打卡成功")
          this.mounted()
        }
      })
    },

  },
  mounted() {
    var pieOption = {
      title: {
        text: '本月打卡情况',
        subtext: '比例图',
        left: 'center'
      },
      tooltip: {
        trigger: 'item',
        formatter: '{a} <br/>{b} : {c} ({d}%)'
      },
      legend: {
        orient: 'vertical',
        left: 'left'
      },
      series: [
        {
          name: "打卡天数",
          type: 'pie',
          radius: '50%',
          center: ['75%', '50%'],
          label:{            //饼图图形上的文本标签
            normal:{
              show:true,
              position:'inner', //标签的位置
              textStyle : {
                fontWeight : 300 ,
                fontSize : 14,    //文字的字体大小
                color: "#fff"
              },
              formatter:'{d}%'
            }
          },
          data: [
          ],  // 填空
          emphasis: {
            itemStyle: {
              shadowBlur: 10,
              shadowOffsetX: 0,
              shadowColor: 'rgba(0, 0, 0, 0.5)'
            }
          }
        }
      ],
    };
    var pieDom = document.getElementById('pie');
    var pieChart = echarts.init(pieDom);
    this.request.get("/echarts/getMonthDkCount",{
      params:{
        empno:this.emp.empno,
      }
    }).then(res => {
      pieOption.series[0].data =[
        {name: "已打卡天数", value: res.data},
        {name: "未打卡天数", value: 30-res.data},
      ]
      pieChart.setOption(pieOption)
    })
  },
}
</script>

<style scoped>

</style>