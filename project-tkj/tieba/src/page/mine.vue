<template>
<div id="container">
    <displayCase :image="image"></displayCase>
    <imageFrame :imageSrc="image"></imageFrame>
    <div id="mainbox">
        <span id="username">{{name}}</span>
        <banner @listenToChildEvent="showMsg"></banner>
        <div v-if="content_control == 0" id="contentbox">
            
        </div>
        <div v-if="content_control == 1" id="contentbox">
            <div id="level">
                <blockLv></blockLv>
            </div>
            <div id="level">
                <blockLv></blockLv>
            </div>
        </div>

        <div v-if="content_control == 2" id="contentbox">
            <achievement achievementName="魔法师" achievementDescribe="hahaha" nowEvolve="10" allEvolve="10"></achievement>
        </div>
        <div v-if="content_control == 3" id="contentbox">
            
        </div>
        <div v-if="content_control == 4" id="contentbox">
            
        </div>
    </div>
    <!--返回顶部-->
    <toTop></toTop>
</div>
</template>

<script>
import image1 from "@/assets/二乔.jpg"

import toTop from "@/components/toTop.vue"
import achievement from "@/components/achievement.vue"
import displayCase from "@/components/displayCase.vue"
import imageFrame from "@/components/imageFrame.vue"
import banner from "@/components/banner.vue"
import blockLv from "@/components/blockLv.vue"
import BlockLv from '../components/blockLv.vue'
import Achievement from '../components/achievement.vue'
export default {
    components:{
        displayCase:displayCase,
        imageFrame:imageFrame,
        banner:banner,
        blockLv:blockLv,
        toTop:toTop,
        achievement:achievement        
    },
    data() {
        return {
            content_control:0,
            name:"  人定胜天!",
            image:image1,
        }
    },
    methods: {
        showMsg:function(data){
            this.content_control = data;
        }
    },
}
</script>

<style>
#username{
    position: relative;
    left: -200px;
}
#mainbox{
    background-color: #eeeeec;
    position: relative;
    top: -120px;

}
#contentbox{
    display: flex;
    justify-content: center;
    background-color: rgb(235, 243, 247);
    position: relative;
    top: -25px;
    width: 1000px;
    height: 1000px;
    border: 2px solid white;
}
#level{
    margin: 30px;
}
</style>