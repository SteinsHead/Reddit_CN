<template>
<div id="tie-page">
<div id="theme"><span>{{theme}}</span></div>
<div id="tie-body" v-for="count in floorN" :key="count"> 
    <floor :storey="count" :headImage="headImage[count-1]" :name="name[count-1]" 
    :level="level[count-1]" :achievement="achievement[count-1]" :replyNum="getReplyNum(count-1)"
    :reply="reply[count-1]"></floor>
    
</div>
<commet></commet>
<toTop></toTop>
</div>  
</template>

<script>
import floor from "@/components/floor.vue";
import toTop from '@/components/toTop.vue';
import commet from '@/components/commet.vue';
export default {
    components:{
        floor:floor,
        toTop:toTop,
        commet:commet
    },
    computed:{
        //获取回复数
        getReplyNum(storey){
            return function(storey){
                if(this.reply[storey] != null){
                    return this.reply[storey].length;
                }
                else{
                    return 0;
                }
            }
        }
    },
    data() {
        return {
            floorN:10,
            theme:"关于王世钢喜欢马晨峰这件事",
            headImage:["https://ae03.alicdn.com/kf/H3e674eece2004db28ae4387dae2406eap.jpg",
                       "https://ae03.alicdn.com/kf/H3e674eece2004db28ae4387dae2406eap.jpg",
                       "https://ae03.alicdn.com/kf/H3e674eece2004db28ae4387dae2406eap.jpg",
                       "https://ae03.alicdn.com/kf/H3e674eece2004db28ae4387dae2406eap.jpg",
                       "https://ae03.alicdn.com/kf/H3e674eece2004db28ae4387dae2406eap.jpg",
                       "https://ae03.alicdn.com/kf/H3e674eece2004db28ae4387dae2406eap.jpg",
                       "https://ae03.alicdn.com/kf/H3e674eece2004db28ae4387dae2406eap.jpg",
                       "https://ae03.alicdn.com/kf/H3e674eece2004db28ae4387dae2406eap.jpg",
                       "https://ae03.alicdn.com/kf/H3e674eece2004db28ae4387dae2406eap.jpg",
                       "https://ae03.alicdn.com/kf/H3e674eece2004db28ae4387dae2406eap.jpg"], 
            name:["爱唱歌的向日葵","光明之魂","神龙","大灭","诺手","卡卡西","茶壶","水杯","键盘侠","小萌心"],
            level:[12,10,9,8,7,6,5,4,3,1],
            achievement:["后起之秀","无称号","无称号","无称号","无称号","无称号","无称号","无称号","无称号","萌新"],
            replyNum:[2,2,2,2,2,0,0,0,0,0],
            reply:[[{id:1,from:"a",to:"b",replyContent:"cnm"},{from:"b",to:"a",replyContent:"wcnm"}],
                    [{id:2,from:"b",to:"a",replyContent:"wcnm"}]]
        }
    },
}
</script>

<style>
#tie-page{
    background-color: #eeeeec;
    width: 90%;
    display: flex;
    flex-direction: column;
    justify-content: center;
}
#theme{
    display: flex;
    align-items: center;
    justify-content: left;
    margin-top: 20px;
    font-size: 18px;
}

</style>