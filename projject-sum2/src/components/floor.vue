<template>
  <div id="floor">
      <div id="floor-body">
        <div id="owner-message">
            <img :src="userPhoto" />
            <span class="span1">{{name}}</span>
            <span class="span1" id="level">lv:{{level}}</span>
        </div>
        <div id="floor-content">
                <span class="span1">{{content}}</span>
        </div>
      </div>
      <div id="floor-bottom">
        <div id="floor-message">
            <span class="span1">{{this.$parent.floorIds[storey-1]-100000}}楼</span>
            <span class="span1">{{replyTime}}</span>
            <span class="span1" id="replyThisFloor" @click="replyThisFloor">回复本层</span>
            <span class="span1" id="show-reply" @click="showReply">查看评论({{replyNum}})</span>
            <span class="span1" id="deleteThisFloor" v-if="storey != 1 && this.$parent.showButtonDeleteThisFloor" @click="deleteThisFloor">删除本楼</span>
        </div>
        <div id="floor-reply" v-show="isShowReply" v-for="mReply in reply_test" :key="mReply.id">
            <reply v-if="mReply.hasOwnProperty('postReplyIntroduce')" 
            :reply="mReply"
            :showButtonDeleteThisReply="showButtonDeleteThisReply"
            :from="mReply.user.userName" 
            :content="mReply.postReplyIntroduce"></reply>
        </div>
  </div>
  </div>
  
</template>

<script>
import reply from '@/components/reply.vue';

export default {
    created() {
        
        let that = this;
        setTimeout(function(){
            let isFloorMaster = false;
            let FloorMaster = that.$parent.tieData[that.storey-1].user.userAccount;
            let myAccount = that.$parent.myAccount;
            if(FloorMaster == myAccount || that.$parent.showButtonDeleteThisFloor){
                that.showButtonDeleteThisReply = true;
            }
            else{
                that.showButtonDeleteThisReply = false;
            }
        },300)
        

    },
    components: {
       reply:reply
    },
    props:{
        userPhoto:String,
        name:String,
        level:String,
        achievement:String,
        content:String,
        storey:Number,
        replyNum:Number,
        replyTime:String,     
    },
    data() {
        return {
            showButtonDeleteThisReply:false,
            isShowReply:false,
            reply_test:[],
        }
    },
    computed:{
        getTime:function(){
            let data = new Date();
            return data.toLocaleString();
        }
    },
    methods: {
        deleteThisFloor:function(){
            let that = this;
            this.$axios.post('/postFloor/banPostFloor',null,{
                params:{
                    sectionId:this.$parent.Sid,
                    sectionPostId:this.$parent.id,
                    postFloorId:this.$parent.floorIds[this.storey-1],
                },
                headers:{
                    token:localStorage.getItem('token'),
                }
            }).then(function(respose){
                if(respose.data){
                    that.$router.replace({
                        path:'/jump',
                        name:'jump'
                    }).catch(err =>{console.log(err)})
                }
                    alert('删除成功');
            })
        },
        replyThisFloor:function(){
            this.isShowReply = !this.isShowReply;
            this.$parent.isShowCommet =!this.$parent.isShowCommet;
            this.$parent.To = this.name;
            this.$parent.where = this.storey;
        },
        showReply:function(){
            let that = this;
            if(!this.isShowReply){
                this.$axios.get('/postReply/findPostReplyBypfId',{
                    params:{
                        sectionId:localStorage.getItem('Sid'),
                        sectionPostId:localStorage.getItem('id'),
                        postFloorId:that.$parent.floorIds[this.storey-1],
                    },
                    headers:{
                        token:localStorage.getItem('token')
                    }
                }).then(function(response){
                    that.reply_test = response.data;
                })
            }
            setTimeout(function(){
                that.isShowReply = !that.isShowReply;
            },100)
            
        }
    },
}
</script>

<style>
#floor{
    border: white 1px solid;
    display: flex;
    flex-direction: column;
    justify-content: center;
}
#floor-body{
    position: relative;
    display: flex;
    flex-direction: row;
    justify-content: left;
}
#owner-message{
    width: 10%;
    border: 1px white solid;
    padding: 5px;
    display: flex;
    flex-direction: column;
    justify-content: center;
    align-items: center;
}
#owner-message > img{
    width: 48px;
    height: 48px;
}
.span1{
    font-size: 12px;
}
#level{
    color: red;
}
#achievement{
    color: green;
}
#floor-content{
    padding:5px;
}
#floor-message{
    border: 1px white solid;
    display: flex;
    flex-direction: row;
    justify-content: space-around;
}
#show-reply{
    cursor: pointer;
}
#replyThisFloor{
    cursor: pointer;
}
</style>