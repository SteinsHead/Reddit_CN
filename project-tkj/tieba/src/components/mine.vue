<template>
<div id="container">
    <displayCase :image="image"></displayCase>
    <imageFrame :imageSrc="image"></imageFrame>
    <div id="mainbox">
        <span id="username">{{name}}</span>
        <banner></banner>
        <div id="contentbox">
            <div id="level">
                
                <blockLv></blockLv>
            </div>
        </div>
    </div>
</div>
</template>

<script>
import image1 from "@/assets/二乔.jpg"

import displayCase from "@/components/displayCase.vue"
import imageFrame from "@/components/imageFrame.vue"
import banner from "@/components/banner.vue"
import blockLv from "@/components/blockLv.vue"
export default {
    components:{
        displayCase:displayCase,
        imageFrame:imageFrame,
        banner:banner,
        blockLv:blockLv
    },
    data() {
        return {
            name:"  人定胜天!",
            image:image1,
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
    /* background-color: #eeeeec; */
    background-color: skyblue;
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