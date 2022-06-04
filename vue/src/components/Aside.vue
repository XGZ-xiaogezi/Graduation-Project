<template>
  <el-menu style="min-height: 100%; overflow-x: hidden"
           background-color="rgb(48, 65, 86)"
           text-color="#fff"
           active-text-color="#409EFF"
           :collapse-transition="false"
           :collapse="isCollapse"
           router
  >
    <div style="height: 60px; line-height: 60px; text-align: center;margin-bottom: 40px">
      <img src="../assets/logo.png" alt="" style="width: 20px; position: relative; top: 5px; right: 5px">
      <b style="color: white" v-show="logoTextShow">OA办公平台</b>
    </div>
    <el-menu-item index="/home">
      <template slot="title">
        <i class="el-icon-house"></i>
        <span slot="title">主页</span>
      </template>
    </el-menu-item>
    <el-menu-item index="/notice">
      <template slot="title">
        <i class="el-icon-chat-round"></i>
        <span slot="title">公告</span>
      </template>
    </el-menu-item>
    <el-menu-item index="/dk">
      <template slot="title">
        <i class="el-icon-map-location"></i>
        <span slot="title">打卡记录</span>
      </template>
    </el-menu-item>
    <el-menu-item index="/todo" v-if="emp.role == 'ROLE_EMP'">
      <template slot="title">
        <i class="el-icon-document-checked"></i>
        <span slot="title">工作任务</span>
      </template>
    </el-menu-item>
    <el-menu-item index="/qj" v-if="emp.role == 'ROLE_EMP'">
      <template slot="title">
        <i class="el-icon-suitcase-1"></i>
        <span slot="title">请假管理</span>
      </template>
    </el-menu-item>
    <el-menu-item index="/meeting" v-if="emp.role == 'ROLE_EMP'">
      <template slot="title">
        <i class="el-icon-data-analysis"></i>
        <span slot="title">会议查看</span>
      </template>
    </el-menu-item>
    <el-menu-item index="/file" v-if="emp.role == 'ROLE_ADMIN'">
      <template slot="title">
        <i class="el-icon-download"></i>
        <span slot="title">文件管理</span>
      </template>
    </el-menu-item>
    <el-menu-item index="/emp_admin" v-if="emp.role == 'ROLE_ADMIN'">
      <template slot="title">
        <i class="el-icon-user"></i>
        <span slot="title">员工管理</span>
      </template>
    </el-menu-item>
    <el-menu-item index="/notice_admin" v-if="emp.role == 'ROLE_ADMIN'">
      <template slot="title">
        <i class="el-icon-s-promotion"></i>
        <span slot="title">公告管理</span>
      </template>
    </el-menu-item>
    <el-menu-item index="/emp_mgr" v-if="emp.role == 'ROLE_MGR'">
      <template slot="title">
        <i class="el-icon-user"></i>
        <span slot="title">部门员工</span>
      </template>
    </el-menu-item>
    <el-menu-item index="/doc" v-if="emp.role == 'ROLE_EMP'">
      <template slot="title">
        <i class="el-icon-s-check"></i>
        <span slot="title">公文发起</span>
      </template>
    </el-menu-item>
    <el-menu-item index="/doc_mgr" v-if="emp.role == 'ROLE_MGR'">
      <template slot="title">
        <i class="el-icon-s-check"></i>
        <span slot="title">公文审核</span>
      </template>
    </el-menu-item>
    <el-menu-item index="/doc_admin" v-if="emp.role == 'ROLE_ADMIN'">
      <template slot="title">
        <i class="el-icon-s-check"></i>
        <span slot="title">公文审核</span>
      </template>
    </el-menu-item>
    <el-menu-item index="/password">
      <template slot="title">
        <i class="el-icon-key"></i>
        <span slot="title">密码修改</span>
      </template>
    </el-menu-item>
    <el-menu-item index="/echarts" v-if="emp.role == 'ROLE_ADMIN'">
      <template slot="title">
        <i class="el-icon-data-line"></i>
        <span slot="title">数据报表</span>
      </template>
    </el-menu-item>
    <el-menu-item index="/qj_mgr" v-if="emp.role == 'ROLE_MGR'">
      <template slot="title">
        <i class="el-icon-edit-outline"></i>
        <span slot="title">请假审批</span>
      </template>
    </el-menu-item>
  </el-menu>
</template>

<script>
export default {
  name: "Aside",
  props: {
    isCollapse: Boolean,
    logoTextShow: Boolean,
  },
  data(){
    return{
      emp: {}
    }
  },
  created() {
    this.getUser()
  },
  methods:{
    getUser() {
      this.emp = localStorage.getItem("emp") ? JSON.parse(localStorage.getItem("emp")) : ""
    }
  }
}
</script>

<style scoped>
.el-menu-item.is-active {
  background-color: rgb(38, 52, 69) !important;
}
.el-menu-item:hover {
  background-color: rgb(38, 52, 69) !important;
}
.el-submenu__title:hover {
  background-color: rgb(38, 52, 69) !important;
}
/*解决收缩菜单文字不消失问题*/
.el-menu--collapse span {
  visibility: hidden;
}
</style>