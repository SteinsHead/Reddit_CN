<template>
<div id="container">
    <div v-if="change" id="change_div">
        <span>修改个人信息</span>
        <myInput ref="newName" content_type="search" placeholder="新的昵称"></myInput>
        <myInput ref="newIntro" content_type="search" placeholder="个人简介"></myInput>
        <myInput ref="newSex" content_type="search" placeholder="性别(男或女)"></myInput>
        <myInput ref="newBirthday" content_type="search" placeholder="出生日期"></myInput>
        <myInput ref="newImage" content_type="search" placeholder="头像url"></myInput>
        <myInput ref="newPhone" content_type="search" placeholder="绑定手机号"></myInput>
        <myInput ref="newEmail" content_type="search" placeholder="绑定邮箱"></myInput>
        <div id="twoButton">
            <myButton msg="确定"  @click.native="changeMessage" :style_parameter="buttonStyle2"></myButton>
            <myButton msg="取消" @click.native="cancel" :style_parameter="buttonStyle2"></myButton>
        </div>
    </div>
    <displayCase :image="image1"></displayCase>
    <imageFrame :imageSrc="image1"></imageFrame>
    <div id="mainbox">
        <div id="div_name">
           <span @click="showRouter" id="username">{{name}}</span>
            <myButton @click.native="toChange" id="buttonMine" :style_parameter="buttonStyle1" msg="修改个人资料"></myButton> 
        </div>
        <span id="myCoin">{{intro}}</span>
        <banner @listenToChildEvent="showMsg"></banner>
        
        <div v-if="content_control == 1" id="contentbox1">
            <div v-for="(section,index) in sectionName" :key="index">
                <div id="level">
                    <blockLv :sectionName="sectionName[index]" :sectionLv="sectionLv[index]"></blockLv>
                </div>
            </div>
        </div>

        <div v-if="content_control == 2" id="contentbox">
            <achievement achievementName="魔法师" achievementDescribe="ads" nowEvolve="10" allEvolve="10"></achievement>
            <achievement achievementName="大魔法师" achievementDescribe="gdddvsv" nowEvolve="6" allEvolve="10"></achievement>
            <achievement achievementName="超级魔法师" achievementDescribe="zczcz" nowEvolve="3" allEvolve="10"></achievement>
            <achievement achievementName="恶魔" achievementDescribe="ghngfnf" nowEvolve="2" allEvolve="10"></achievement>
            <achievement achievementName="我曾踏足山峰" achievementDescribe="wrwev" nowEvolve="11" allEvolve="100"></achievement>
            <achievement achievementName="也曾跌落低谷" achievementDescribe="hahaha" nowEvolve="10" allEvolve="1000"></achievement>

        
        </div>
        <div v-if="content_control == 3" id="contentbox">
            <simpleTie block="游戏" owner="刚刚" theme="啊哈哈哈哈哈啊哈哈哈哈哈"></simpleTie>
            <simpleTie block="游戏" owner="刚刚" theme="啊哈哈哈哈哈啊哈哈哈哈哈"></simpleTie>
            <simpleTie block="游戏" owner="刚刚" theme="啊哈哈哈哈哈啊哈哈哈哈哈"></simpleTie>
            <simpleTie block="游戏" owner="刚刚" theme="啊哈哈哈哈哈啊哈哈哈哈哈"></simpleTie>
        </div>
        <div v-if="content_control == 4" id="contentbox">
            <simpleTie block="游戏" owner="刚刚" theme="啊哈哈哈哈哈啊哈哈哈哈哈"></simpleTie>
            <simpleTie block="游戏" owner="刚刚" theme="啊哈哈哈哈哈啊哈哈哈哈哈"></simpleTie>
            <simpleTie block="游戏" owner="刚刚" theme="啊哈哈哈哈哈啊哈哈哈哈哈"></simpleTie>
            <simpleTie block="游戏" owner="刚刚" theme="啊哈哈哈哈哈啊哈哈哈哈哈"></simpleTie>
        </div>
    </div>
    <!--返回顶部-->
    <toTop></toTop>
</div>
</template>

<script>
import image1 from "@/assets/二乔.jpg"

import simple_tie from "@/components/simple_tie.vue"
import toTop from "@/components/toTop.vue"
import achievement from "@/components/achievement.vue"
import displayCase from "@/components/displayCase.vue"
import imageFrame from "@/components/imageFrame.vue"
import banner from "@/components/banner.vue"
import blockLv from "@/components/blockLv.vue"
import BlockLv from '@/components/blockLv.vue'
import Achievement from '@/components/achievement.vue'
import Simple_tie from '@/components/simple_tie.vue'
import myButton from '@/components/button.vue'
import myInput from '@/components/input.vue'

export default {
    components:{
        displayCase:displayCase,
        imageFrame:imageFrame,
        banner:banner,
        blockLv:blockLv,
        toTop:toTop,
        achievement:achievement,
        simpleTie:simple_tie,
        myButton:myButton,
        myInput:myInput
    },
    data() {
        return {
            change:false,
            buttonStyle1:{
                'width':'100px',
                'borderRadius':"5px",      
            },
            buttonStyle2:{
                'backgroundColor':'#3f89ec',
                'borderRadius':"5px",      
            },
            content_control:1,
            name:"",
            sex:"",
            intro:"",
            birthday:"",
            phone:"",
            email:"",
            image:"",
            sectionName:[],
            sectionLv:[],
            coin:20,
            image1:image1,
            token:"",
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
                    here.token = here.$route.params.token;

                    here.name = response.data.userName;
                    here.sex = response.data.userSex;
                    here.birthday = response.data.userBirthday;
                    here.image = response.data.userPhoto;
                    here.phone = response.data.userPhone;
                    here.email = response.data.userEmail;
                    here.intro = response.data.userInfroduce;
                    for(let i =0;i<response.data.sectionList.length;i++){
                        here.sectionName.push(response.data.sectionList[i].sectionName);
                        here.sectionLv.push(response.data.sectionList[i].sectionUser.sectionUserRank);
                    }
                })
            }
            else{
                console.log(response.data.sectionList[0].sectionName);
                that.token = localStorage.getItem('token');
                that.name = response.data.userName;
                that.sex = response.data.userSex;
                that.birthday = response.data.userBirthday;
                that.image = response.data.userPhoto;
                that.phone = response.data.userPhone;
                that.email = response.data.userEmail;
                that.intro = response.data.userIntroduce;
                for(let i =0;i<response.data.sectionList.length;i++){
                    that.sectionName.push(response.data.sectionList[i].sectionName);
                    that.sectionLv.push(response.data.sectionList[i].sectionUser.sectionUserRank);
                }
            }
        })
    },
    methods: {
        changeMessage:function() {
            let name = this.$refs.newName.value == "" ?this.name:this.$refs.newName.value;
            let intro = this.$refs.newIntro.value== "" ?this.intro: this.$refs.newIntro.value;            
            let sex = this.$refs.newSex.value== "" ?this.sex: this.$refs.newSex.value;
            let birthday = this.$refs.newBirthday.value== "" ?this.birthday: this.$refs.newBirthday.value;
            let image = this.$refs.newImage.value== "" ?this.image: this.$refs.newImage.value;
            let phone = this.$refs.newPhone.value== "" ?this.phone: this.$refs.newPhone.value;
            let email = this.$refs.newEmail.value== "" ?this.email: this.$refs.newEmail.value;
            
            let that = this;
            console.log(name+intro+sex+birthday+image+phone+email);
            let tips="";
                this.$axios.post("/user/updateUserEmail",null,{
                    params:{
                        userEmail:email,
                    },
                    headers:{
                        token:this.token,
                    }
                }).then(function(response){
                    console.log(response.data)
                    if(response.data){
                    }
                });
                this.$axios.post("/user/updateUserPhone",null,{
                    params:{
                        userPhone:phone,
                    },
                    headers:{
                        token:this.token,
                    }
                }).then(function(response){
                    if(response.data){
                    }
                })
            this.$axios.post("/user/updateUserInformation",null,{
                params:{
                    userName:name,
                    userSex:sex,
                    userBirthday:birthday,
                    userPhoto:image,
                    userIntroduce:intro,
                },
                headers:{
                    token:this.token,
                }
            }).then(function(response){
                if(response.data){
                    tips+="修改个人资料成功";
                }
            })

            setTimeout(function(){
                alert(tips);
                that.change =false;
            },500);

            
        },
        cancel:function() {
            this.change = false;
        },
        toChange:function(){
            this.change = true;
        },
        showMsg:function(data){
            this.content_control = data;
        },
        showRouter:function(){
            
        }
    },
}
</script>

<style>
#buttonMine{
    position: absolute;
    right: 0;
}
#div_name{
    position: relative;
    display: flex;
    flex-direction: row;
}
#username{
    position: relative;
    left: -200px;
}
#mainbox{
    display: flex;
    flex-direction: column;
    justify-content: center;
    align-items: center;
    background-color: #eeeeec;
    position: relative;
    top: -120px;

}
#contentbox{
    display: flex;
    flex-direction: column;
    align-items: center;
    background-color: rgb(235, 243, 247);
    position: relative;
    top: -25px;
    width: 1000px;
    height: 1000px;
    border: 2px solid white;
}
#twoButton{
    display: flex;
    flex-direction: row;
    justify-content: space-around;
}
#contentbox1{
    display:flex;
    background-color: rgb(235, 243, 247);
    position: relative;
    top: -25px;
    width: 1000px;
    height: 1000px;
    border: 2px solid white;
}
#level{
    position: relative;
    margin: 30px;
}
#myCoin{
    margin-top: 30px;
    font-size: 12px;
    position: relative;
    left: -200px;
}
#change_div{
    z-index: 10;
    background-color: white;
    top: 30%;
    left: 40%;
    position: fixed;
    display: flex;
    flex-direction: column;
    justify-content: center;
    border-radius: 10px;
    border: 5px solid white;
    box-shadow: 1px 1px 1px black;
}
</style>