import Vue from 'vue'
import Router from 'vue-router'

import login from '@/page/login'
import mine from '@/page/mine'
Vue.use(Router)

export default new Router({
  routes: [
    {
      path: '/login',
      name: 'login',
      component:login
    },
    {
      path: '/mine',
      name: 'mine',
      component:mine
    },
  ]
})
