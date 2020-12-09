<template>
<div id="tie-page" v-if="showTiePage">
<div id="theme"><span>{{theme}}</span></div>
<div id="tie-body" v-for="count in floorN" :key="count"> 
    <floor :storey="count"
    :showButtonDeleteThisFloor="showButtonDeleteThisFloor"
    :userPhoto="'https://redditcn-1301983393.cos.ap-beijing.myqcloud.com/'+tieData[count-1].user.userPhoto" 
    :name="tieData[count-1].user.userName" 
    :level="tieData[count-1].user.sectionUser.sectionUserRank" 
    :replyNum="tieData[count-1].postFloorReply"
    :content="tieData[count-1].postFloorIntroduce" 
    :replyTime="tieData[count-1].postFloorTime"></floor>
    
</div>
<commet @click.native="showCommet"></commet>
    <textarea id="textarea" v-if="isShowCommet"></textarea>
    <button id="send" @click="sendCommet" v-if="isShowCommet">发送</button>
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
        commet:commet,
    },
    created:function(){
        
        let that = this;
        let id = localStorage.getItem('id');
        let Sid = localStorage.getItem('Sid');
        this.id = id;
        this.Sid = Sid;
        let content = localStorage.getItem('content');
        this.theme = content;//帖子主题
        
        this.$router.push({
            name:'tie',
            params:{
                id:id,
                Sid:Sid,
                content:content
            }
        }).catch(err =>{console.log(err)})
        //检测token
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
                    else{
                        here.myAccount = response.data.userAccount;
                    }
                })
            }
            else{
                that.myAccount = response.data.userAccount;
            }
        })

        //获取所有的楼层
        if(localStorage.getItem('isShowMineFloor')){
            this.$axios.get("/postFloor/findMinePostFloor",{
                params:{ 
                    sectionId:Sid,
                    sectionPostId:id
                },
                headers:{
                    token:localStorage.getItem('token')
            }
            }).then(function(response){
                that.floorN = response.data.length;
                that.tieData = response.data;
                that.TieMaster = response.data[0].user.userAccount;
                for(let i=0;i<that.floorN;i++){
                    that.floorIds.push(that.tieData[i].postFloorId);
                }
            });
            localStorage.setItem('isShowMineFloor',false);
        }
        else{
            this.$axios.get("/postFloor/findAllPostFloor",{
                params:{ 
                    sectionId:Sid,
                    sectionPostId:id
                },
                headers:{
                    token:localStorage.getItem('token')
                }
            }).then(function(response){
                that.floorN = response.data.length;
                that.tieData = response.data;
                that.TieMaster = response.data[0].user.userAccount;
                for(let i=0;i<that.floorN;i++){
                    that.floorIds.push(that.tieData[i].postFloorId);
                }
            });
        }
        //检测权限
            that.$axios.get('/sectionUser/findSectionCreater',{
            params:{
                sectionId:Sid,
            },
            headers:{
                token:localStorage.getItem('token'),
            }
        }).then(function(response){
            if(response.data.hasOwnProperty('userAccount')){
                that.sectionMaster = response.data.userAccount;
            }
            if(that.myAccount == that.sectionMaster || that.myAccount == that.TieMaster){
                that.showButtonDeleteThisFloor = true;
            }
            else{
                that.showButtonDeleteThisFloor = false;
            }
            console.log('## '+that.sectionMaster+" "+ that.TieMaster+" "+that.myAccount);
            that.showTiePage = true;
        })           
    },
    methods: {
        //   回复帖子／楼层
        sendCommet:function(){
            let that = this;
            let content = document.getElementById('textarea').value;
            if(this.where == -1){    
                if(content.length == 0){
                    alert("请输入内容");
                }
                else{
                    
                    this.$axios.post("/postFloor/insertPostFloor",null,{
                        params:{
                            sectionId:this.Sid,
                            sectionPostId:this.id,
                            postFloorIntroduce:content,
                            postFloorPhoto:"null",
                        },
                        headers:{
                            token:localStorage.getItem("token"),
                        }
                    }).then(function(response){
                        document.getElementById('textarea').value = "";
                        that.isShowCommet = false;
                        location.reload();
                        alert("评论成功");
                    })

                }
            }
            else{
                if(content.length == 0){
                    alert("请输入内容");
                }
                else{

                    this.$axios.post('/postReply/insertPostReply',null,{
                        params:{
                            sectionId:this.Sid,
                            sectionPostId:this.id,
                            postFloorId:this.floorIds[this.where-1],
                            postReplyIntroduce:content,
                        },
                        headers:{
                            token:localStorage.getItem('token'),
                        }
                    }).then(function(response){
                    })
                    alert("评论成功");
                    document.getElementById('textarea').value = "";
                    this.isShowCommet = false;
                    this.where = -1;
                    location.reload();

                }
            }
        },
        showCommet:function(){
            this.isShowCommet = !this.isShowCommet;
        }
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
            showTiePage:false,
            showButtonDeleteThisFloor:false,
            sectionMaster:'',
            TieMaster:'',
            myAccount:'',
            Sid:0,
            id:0,
            floorIds:[],
            tieData:[],
            token:"",
            where:-1,
            isShowCommet:false,
            floorN:0,
            theme:""
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
textarea{
    position: fixed;
    bottom: 20px;
    left: 10%;
    width: 80%;
    height: 200px;
    resize: none;
}
#send{
    position: fixed;
    bottom: 20px;
    right: 10%;
    width: 50px;
    height: 20px;
}
</style>