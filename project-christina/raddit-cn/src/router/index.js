import Vue from 'vue'
import Router from 'vue-router'
import HelloWorld from '@/components/HelloWorld'
import logo from '@/components/logo'
import banner from '@/components/topBanner'
import block from '@/components/topBlock'
import page from '@/Pages/firstpage'
import area from '@/components/areaBlock'

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
      component: block
    },
    {
      path: '/firstpage',
      name: 'page',
      component: page,
    },
    {
      path: '/area',
      name: 'area',
      component: area,
    },
  ]
})
