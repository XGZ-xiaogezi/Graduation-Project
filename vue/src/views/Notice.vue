<template>
  <div style="color: #666;font-size: 14px;">
    <div style="padding-bottom: 20px">
      <b>您好！{{ emp.ename }}</b>
    </div>
    <el-card>
      欢迎使用办公自动化系统！
      <el-divider />
      2022，毕业顺利！
    </el-card>

<!--    <el-card style="margin: 10px 0">-->
<!--      <div style="padding-bottom: 20px; font-size: 24px">简 单 的 系 统 公 告</div>-->
<!--      <el-collapse accordion v-model="activeNames" v-for="(item, index) in notice">-->
<!--        <el-collapse-item :name="index + ''">-->
<!--          <template slot="title">-->
<!--            <span style="font-size: 20px; color: #E6A23C">{{ item.name }}</span><i style="color: #E6A23C" class="header-icon el-icon-info"></i>-->
<!--            <span style="margin-left: 20px">{{ item.time }}</span>-->
<!--          </template>-->
<!--          <div>-->
<!--            <div style="padding: 10px 0"><el-image :src="item.img"></el-image></div>-->
<!--            <div>{{ item.content }}</div>-->
<!--          </div>-->
<!--        </el-collapse-item>-->
<!--      </el-collapse>-->
<!--    </el-card>-->

    <el-card style="margin: 10px 0">
      <div style="padding-bottom: 20px; font-size: 24px">富 文 本 系 统 公 告</div>
      <el-collapse accordion v-for="(item, index) in noticeRich">
        <el-collapse-item :name="index + ''">
          <template slot="title">
            <span style="font-size: 20px; color: #E6A23C">{{ item.name }}</span><i style="color: #E6A23C" class="header-icon el-icon-info"></i>
            <span style="margin-left: 20px">{{ item.time }}</span>
          </template>
          <div>
            <div style="padding: 10px 0"><el-image :src="item.img"></el-image></div>
            <div v-html="item.content"></div>
          </div>
        </el-collapse-item>
      </el-collapse>
    </el-card>

  </div>
</template>

<script>
export default {
  name: "Notice",
  data() {
    return {
      activeNames: ['0'],
      emp: localStorage.getItem("emp") ? JSON.parse(localStorage.getItem("emp")) : {},
      notice: [],
      noticeRich: [],
    }
  },
  created() {
    // 简单公告
    this.request.get("/notice/type/1").then(res => {
      this.notice = res.data.splice(0, 5)
    })

    this.request.get("/notice/type/2").then(res => {
      this.noticeRich = res.data.splice(0, 5)
    })
  }
}
</script>

