import Vue from 'vue'
import Router from 'vue-router'
import HelloWorld from '@/components/HelloWorld'
import page from '@/Pages/firstpage'
import admin from '@/Pages/adminpage'
import plate from '@/Pages/platepage'
import login from '@/page/login'
import mine from '@/page/mine'
import message from '@/page/message'
import tie from '@/page/tie'

Vue.use(Router)

export default new Router({
  routes: [
    {
      path: '/',
      name: 'HelloWorld',
      component: HelloWorld
    },
    {
      path: '/firstpage',
      name: 'page',
      component: page,
    },
    {
      path: '/adminpage',
      name: 'admin',
      component: admin,
    },
    {
      path: '/platepage',
      name: 'plate',
      component: plate,
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
