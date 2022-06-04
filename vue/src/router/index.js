import Vue from 'vue'
import VueRouter from 'vue-router'
import store from "@/store";

Vue.use(VueRouter)

const routes = [
  {
    path: '/',
    component: () => import('../views/Manage.vue'),
    redirect: "/home",
    children: [
      { path: 'home', name: '首页', component: () => import('../views/Home.vue')},
      { path: 'todo', name: '工作任务', component: () => import('../views/Todo.vue')},
      { path: 'user', name: '用户管理', component: () => import('../views/User.vue')},
      { path: 'file', name: '文件管理', component: () => import('../views/File.vue')},
      { path: 'notice', name: '公告', component: () => import('../views/Notice.vue')},
      { path: 'dk', name: '打卡记录', component: () => import('../views/Dk.vue')},
      { path: 'qj', name: '请假管理', component: () => import('../views/Qj.vue')},
      { path: 'meeting', name: '会议管理', component: () => import('../views/Meeting.vue')},
      { path: 'emp_admin', name: '员工管理', component: () => import('../views/Emp_Admin.vue')},
      { path: 'notice_admin', name: '公告管理', component: () => import('../views/Notice_Admin.vue')},
      { path: 'emp_mgr', name: '部门员工', component: () => import('../views/Emp_Mgr.vue')},
      { path: 'person', name: '个人信息', component: () => import('../views/person.vue')},
      { path: 'doc', name: '公文发起', component: () => import('../views/Doc.vue')},
      { path: 'doc_mgr', name: '公文审核(部门)', component: () => import('../views/Doc_Mgr.vue')},
      { path: 'doc_admin', name: '公文审核', component: () => import('../views/Doc_Admin.vue')},
      { path: 'password', name: '密码修改', component: () => import('../views/Password.vue')},
      { path: 'echarts', name: '数据报表', component: () => import('../views/Echarts.vue')},
      { path: 'qj_mgr', name: '请假审批', component: () => import('../views/Qj_Mgr.vue')},
    ]
  },
  {
    path: '/login',
    name: 'Login',
    component: () => import('../views/Login.vue')
  },
  {
    path: '/register',
    name: 'Register',
    component: () => import('../views/Register.vue')
  }
]

const router = new VueRouter({
  mode: 'history',
  base: process.env.BASE_URL,
  routes
})

// 路由守卫
router.beforeEach((to, from, next) => {
  localStorage.setItem("currentPathName", to.name)  // 设置当前的路由名称，为了在Header组件中去使用
  store.commit("setPath")  // 触发store的数据更新
  next()  // 放行路由
})
// const originalPush = VueRouter.prototype.push
// VueRouter.prototype.push = function push(location) {
//   return originalPush.call(this, location).catch(err => err)
// }
export default router