import Vue from 'vue'
import Router from 'vue-router'
import HelloWorld from '@/components/HelloWorld'
import logo from '@/components/logo'
import banner from '@/components/topBanner'
import block from '@/components/topBlock'

Vue.use(Router)

export default new Router({
  routes: [
    {
      path: '/',
      name: 'HelloWorld',
      component: HelloWorld
    },
    {
      path: '/logo',
      name: 'logo',
      component: logo
    },
    {
      path: '/banner',
      name: 'banner',
      component: banner
    },
    {
      path: '/block',
      name: 'block',
      component:block
    },
  ]
})
