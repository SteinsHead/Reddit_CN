import Vue from 'vue'
import Router from 'vue-router'
import HelloWorld from '@/components/HelloWorld'
import login from '@/components/login'
import button from '@/components/button'
import mine from '@/components/mine'
Vue.use(Router)

export default new Router({
  routes: [
    {
      path: '/home',
      name: 'HelloWorld',
      component: HelloWorld
    },
    {
      path: '/test',
      name: 'button',
      component:button
    },
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
