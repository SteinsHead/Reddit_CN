import Vue from 'vue'
import Router from 'vue-router'

import login from '@/page/login'
import mine from '@/page/mine'
import message from '@/page/message'
import tie from '@/page/tie'
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
    {
      path: '/message',
      name: 'message',
      component:message
    },
    {
      path: '/tie',
      name: 'tie',
      component:tie
    },
  ]
})
