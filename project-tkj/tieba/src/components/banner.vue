<template>
  <div id="banner">
      <myButton id="bannerbutton1" @click.native="select1" :style_parameter="buttonStyle" :msg="whatButton1"></myButton>
      <myButton id="bannerbutton2" @click.native="select2" :style_parameter="buttonStyle" :msg="whatButton2"></myButton>
      <myButton id="bannerbutton3" @click.native="select3" :style_parameter="buttonStyle" :msg="whatButton3"></myButton>
      <myButton id="bannerbutton4" @click.native="select4" :style_parameter="buttonStyle" :msg="whatButton4"></myButton>
  </div>
</template>

<script>
import button from "@/components/button.vue"
export default {
    components:{
        myButton:button
    },
    data() {
        return {
            whatButton1:"板块等级",
            whatButton2:"我的成就",
            whatButton3:"我的收藏",
            whatButton4:"浏览历史",
            buttonStyle:{
                "border-style":'none',
                'color':'grey',
                'font-weight':'400',
                'cursor':'pointer',
                "border":"20px",
                "border-radius":"5px",
                "margin-right":"8px",
                "margin-left":"8px",
                "transition":".5s ease-in-out",
            }
        }
    },
    methods:{
        setZIndex:function(idname){
            let ids = ['bannerbutton1','bannerbutton2','bannerbutton3','bannerbutton4'];
            for(let i = 0;i<ids.length;i++){
                if(idname != ids[i])
                    document.getElementById(ids[i]).style.zIndex = 0;
            }
            document.getElementById(idname).style.zIndex = 1;
        },
        select1:function(){
            this.setZIndex('bannerbutton1');
            document.getElementById("bannerbutton1").style.backgroundColor = "#eeeeec";
        },
        select2:function(){
            this.setZIndex('bannerbutton2');
            document.getElementById("bannerbutton2").style.backgroundColor = "#eeeeec";
        },
        select3:function(){
            this.setZIndex('bannerbutton3');
            document.getElementById("bannerbutton3").style.backgroundColor = "#eeeeec";
        },
        select4:function(){
            this.setZIndex('bannerbutton4');
            document.getElementById("bannerbutton4").style.backgroundColor = "#eeeeec";
        },

    }
}
</script>

<style scoped>
#banner{
    width: 600px;
    display: flex;
    justify-content: center;
    margin-top: 50px;
    margin-left: 180px;
    margin-right: 180px;
    padding: 20px;
}
</style>>
