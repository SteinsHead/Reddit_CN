<template>
  <div id="message-body">
    <div id="left-body">
        <div id="option" >
            <span @click="myTie">我的帖子</span>
            <div class="triple-right"></div>
        </div>
        <div id="option" >
            <span @click="myFloor">我的楼层</span>
            <div class="triple-right"></div>
        </div>
    </div>

    <div id="right-body">
        <div id="msg-box" v-show="replyMe" v-for="(MyOneTieData,index) in myTieData" :key="index">
            <simpleMsg
             :sectionPostId="MyOneTieData.sectionPostId"
             :sectionId="MyOneTieData.sectionId" 
             :sectionName="MyOneTieData.sectionName"
             :sectionPostName="MyOneTieData.sectionPostName"
             :sectionPostTime="MyOneTieData.sectionPostTime"
             :sectionPostFloor="MyOneTieData.sectionPostFloor">
            </simpleMsg>
        </div>
        <div id="msg-box" v-show="officalMsg" v-for="(MyOneFloorData,index) in myFloorData" :key="'info2-'+index">
            <simpleFloor
             :sectionPostId="MyOneFloorData.sectionPostId"
             :sectionId="MyOneFloorData.sectionId"               
             :sectionName="MyOneFloorData.sectionName"
             :sectionPostName="MyOneFloorData.sectionPostName"
             :postFloorIntroduce="MyOneFloorData.postFloorIntroduce"
             :postFloorTime="MyOneFloorData.postFloorTime"
             :postFloorReply="MyOneFloorData.postFloorReply" ></simpleFloor>
        </div>
    </div>
    <toTop></toTop>
  </div>
</template>

<script>
import simple_msg from "@/components/simple_msg.vue"
import toTop from "@/components/toTop.vue"
import simpleFloor from "@/components/simpleFloor.vue"
export default {
    components:{
        simpleMsg:simple_msg,
        toTop,toTop,
        simpleFloor:simpleFloor
    },
    methods: {
        myTie:function(){
            let that = this;
            this.$axios.get('/user/findUserSectionPost',{
                headers:{
                    token:localStorage.getItem('token'),
                }
            }).then(function(response){
                if(response.data.length > 0){
                    that.myTieData = response.data;
                }
            })
            setTimeout(function(){
                that.replyMe = true;
                that.officalMsg = false;
            },100)
        },
        myFloor:function(){
            let that = this;
            this.$axios.get('/user/findUserPostFloor',{
                headers:{
                    token:localStorage.getItem('token'),
                }
            }).then(function(response){
                if(response.data.length > 0){
                    that.myFloorData = response.data;
                }
            })
            setTimeout(function(){
                that.officalMsg = true;
                that.replyMe = false;
            },100)
            
        }
    },
    data() {
        return {
            myTieData:[],
            myFloorData:[],
            replyMe:false,
            officalMsg:false,
        }
    },
    created:function(){
        let that = this;
        this.$axios.get("/user/findUserMine",{
            headers:{
                token:localStorage.getItem('token')
            }
        }).then(function(response){
            if(response.data.hasOwnProperty("errmsg")){
                let here = that;
                that.$axios.get("/user/findUserMine",{
                    headers:{
                        token:that.$route.params.token
                    }
                }).then(function(response){
                    if(response.data.hasOwnProperty("errmsg")){
                        alert("登陆过期，请重新登录！");
                        window.open("/#/login",name='_self');
                    }
                })
            }
        })
    }

}
</script>

<style>
#option{
    position: relative;
    color: white;
    display: flex;
    justify-content: center;
    align-items: center;
    height: 50px;
    border-bottom: 1px solid #376aac;
    background-color: #2059a3;
    cursor: pointer;
}
#option:hover > div{
    border-right-color: #eeeeec;
}
#option > span{
    position: relative;
}

/* 右三角 */
.triple-right{
    position: absolute;
    right: 0;
    width:0;
    height:0;
    overflow:hidden;
    font-size: 0;     /*是因为, 虽然宽高度为0, 但在IE6下会具有默认的 */
    line-height: 0;  /* 字体大小和行高, 导致盒子呈现被撑开的长矩形 */
    border-width:10px;
    border-style:solid dashed dashed dashed;/*IE6下, 设置余下三条边的border-style为dashed,即可达到透明的效果*/
    border-color: transparent #2059a3 transparent transparent;
}


#message-body{
    width: 80%;
    display: flex;
    flex-direction: row;
    margin-top: 30px;
    background-color: #eeeeec;
}
#left-body{
    display: flex;
    flex-direction: column;
    width: 15%;
    height: 800px;
    background-color: #3f7ac6;
}
#right-body{
    display: flex;
    flex-direction: column;
    align-items: center;
    width: 85%;
}
#msg-box{
    width: 90%;
}
</style>