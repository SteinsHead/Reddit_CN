<template>
  <div class="hello">
    <base-input :style_parameter="url" :content_type="password"></base-input>
    <h1>{{ msg }}</h1>
    <h2>Essential Links</h2>
  </div>
</template>

<script>
import Input from '@/components/Input'
import image from '@/assets/geren.png'
export default {
  name: 'HelloWorld',
  components:{
    'base-input':Input
  },
  data () {
    return {
      password: 'password',
      url: {
            'background-image': 'url("'+image+'")', 
      },
      msg: 'Welcome to My Vue.js App'
    }
  }
}
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped>
h1, h2 {
  font-weight: normal;
}
</style>
