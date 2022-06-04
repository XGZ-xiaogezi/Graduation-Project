<template>
  <div>
    <el-row :gutter="20" style="margin-bottom: 60px">
      <el-col :span="8">
        <el-card style="color: #409EFF">
          <div><i class="el-icon-user-solid" /> 员工总数</div>
          <div style="padding: 10px 0; text-align: center; font-weight: bold">
            {{empCount}}
          </div>
        </el-card>
      </el-col>
      <el-col :span="8">
        <el-card style="color: #F56C6C">
          <div><i class="el-icon-money" /> 今日未打卡</div>
          <div style="padding: 10px 0; text-align: center; font-weight: bold">
            {{empCount-todayDk}}
          </div>
        </el-card>
      </el-col>
      <el-col :span="8">
        <el-card style="color: #67C23A">
          <div><i class="el-icon-bank-card" /> 今日打卡人数</div>
          <div style="padding: 10px 0; text-align: center; font-weight: bold">
            {{ todayDk }}
          </div>
        </el-card>
      </el-col>
    </el-row>
    <el-row>
      <el-col :span="12">
        <div id="pie" style="width: 500px; height: 400px"></div>
      </el-col>
      <el-col :span="12">
        <div id="pie2" style="width: 500px; height: 400px"></div>
      </el-col>
    </el-row>
  </div>
</template>
<script>
import * as echarts from "echarts";

export default {
  name: "Echarts",
  data(){
    return{
      todayDk: 0,
      empCount: 0,
    }
  },
  mounted() {
    // 饼图

    var pieOption = {
      title: {
        text: '打卡时间段统计',
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
          name: "员工打卡时间",
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
    var pieOption2 = {
      title: {
        text: '各部门人数比例',
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
          name: "部门人数",
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
    var pieDom2 = document.getElementById('pie2');
    var pieChart = echarts.init(pieDom);
    var pieChart2 = echarts.init(pieDom2);
    this.request.get("/echarts/getDkInfo").then(res => {
      pieOption.series[0].data =[
        {name: "7:30~8:00", value: res.data[0]},
        {name: "8:00~8:30", value: res.data[1]},
        {name: "8:30~9:00", value: res.data[2]},
        {name: "9:00~9:30", value: res.data[3]},
        {name: "其他时间段", value: res.data[4]},
      ]
      pieChart.setOption(pieOption)
    })
    this.request.get("/echarts/getDeptCount").then(res => {
      pieOption2.series[0].data =[
        {name: "管理部", value: res.data[0]},
        {name: "销售部", value: res.data[1]},
        {name: "研发部", value: res.data[2]},
        {name: "财务部", value: res.data[3]},
        {name: "测试部", value: res.data[4]},
      ]
      pieChart2.setOption(pieOption2)
    })
    this.request.get("/echarts/getTodayDk").then(res => {
        this.todayDk = res.data;
    })
    this.request.get("/echarts/getEmpCount").then(res => {
      this.empCount = res.data;
    })
  }
}
</script>

<style scoped>

</style>