<template>
  <!-- 登录 -->
  <div v-if="isLoginShow" id="login">
    <h4>{{ title1 }}</h4>
    <div class="box1">
      <my-input
        ref="account"
        :placeholder="placeholder11"
        :style_parameter="style_parameter1"
        :content_type="search"
      ></my-input>
    </div>
    <div class="box1">
      <my-input
        ref="password"
        :placeholder="placeholder12"
        :style_parameter="style_parameter2"
        :content_type="password"
      ></my-input>
      <my-button
        @click.native="goForget"
        :style_parameter="style_parameter_forgetButton"
        msg="忘记密码?"
      ></my-button>
    </div>
    <div class="box2">
      <my-button
        :style_parameter="style_parameter_loginButton"
        @click.native="goHome"
        msg="登录"
      ></my-button>
    </div>
    <div class="box3">
      <my-button
        @click.native="goRegister"
        :style_parameter="style_parameter_registerButton"
        msg="去注册"
      ></my-button>
    </div>
  </div>
  <!-- 找回密码  -->
  <div v-else-if="isForgetShow" id="login">
    <h4>{{ title2 }}</h4>
    <div class="box1">
      <my-input
        :placeholder="placeholder1"
        :style_parameter="style_parameter1"
        :content_type="search"
      ></my-input>
      <my-button
        :style_parameter="style_parameter_forgetButton"
        msg="发送验证码"
      ></my-button>
    </div>
    <div class="box1">
      <my-input
        :placeholder="placeholder3"
        :style_parameter="style_parameter4"
      ></my-input>
    </div>
    <div class="box1">
      <my-input
        :placeholder="placeholder4"
        :style_parameter="style_parameter2"
        :content_type="password"
      ></my-input>
    </div>
    <div class="box1">
      <my-input
        :placeholder="placeholder5"
        :style_parameter="style_parameter2"
        :content_type="password"
      ></my-input>
    </div>
    <div class="box2">
      <my-button
        :style_parameter="style_parameter_loginButton"
        @click.native="goLogin"
        msg="完成"
      ></my-button>
    </div>
    <div class="box3">
      <my-button
        @click.native="goRegister"
        :style_parameter="style_parameter_registerButton"
        msg="去注册"
      ></my-button>
    </div>
  </div>
  <!-- 注册密码 -->
  <div v-else-if="isRegisterShow" id="login">
    <h4>{{ title3 }}</h4>
    <div class="box1">
      <my-input
        ref="registerName"
        :placeholder="placeholder1"
        :style_parameter="style_parameter1"
        :content_type="search"
      ></my-input>
    </div>
    <div class="box1">
      <my-input
        ref="registerAccount"
        :placeholder="placeholder3"
        :style_parameter="style_parameter4"
      ></my-input>
    </div>
    <div class="box1">
      <my-input
        ref="registerPassword"
        :placeholder="placeholder6"
        :style_parameter="style_parameter2"
        :content_type="password"
      ></my-input>
    </div>
    <div class="box2">
      <my-button
        :style_parameter="style_parameter_loginButton"
        @click.native="goLogin"
        msg="完成"
      ></my-button>
    </div>
  </div>
</template>
<script>
import Input from "@/components/input.vue";
import button from "@/components/button.vue";

import Image_geren from "@/assets/geren.png";
import Image_mima from "@/assets/mima.png";
import Image_yanzhengma from "@/assets/yanzhengma.png";

import Vue from "vue";
export default {
  components: {
    "my-input": Input,
    "my-button": button,
  },

  data() {
    return {
      token: "",
      title1: "账号登录",
      title2: "找回密码",
      title3: "注册账号",

      isLoginShow: true,
      isForgetShow: false,
      isRegisterShow: false,

      search: "search",
      password: "password",
      style_parameter1: {
        "background-image": "url('" + Image_geren + "')",
      },
      placeholder1: "请输入昵称",

      placeholder11: "请输入账号",
      placeholder12: "请输入密码",

      style_parameter2: {
        "background-image": "url('" + Image_mima + "')",
      },
      placeholder2: "请输入账号",

      style_parameter3: {
        "background-image": "url('" + Image_mima + "')",
      },
      placeholder3: "请输入账号",

      style_parameter4: {
        "background-image": "url('" + Image_yanzhengma + "')",
      },
      placeholder4: "请输入新密码",
      placeholder5: "请重复新密码",
      placeholder6: "请设置登录密码",
      style_parameter_loginButton: {
        "background-color": "#3f89ec",
        width: "180px",
        "border-radius": "5px",
        "font-weight": "400",
        color: "white",
      },

      style_parameter_forgetButton: {
        "border-style": "none",
        color: "grey",
        "font-weight": "400",
      },
      style_parameter_registerButton: {
        "border-style": "none",
        color: "grey",
        "font-weight": "500",
      },
    };
  },
  methods: {
    goHome: function (event) {
      let that = this;
      let account = this.$refs.account.value;
      let password = this.$refs.password.value;
      if (account == "" || password == "") {
        alert("不能输入空的内容");
        return false;
      }
      this.$axios
        .get("/user/loginInByAnyway", {
          params: {
            userAccount: account,
            userPassword: password,
          },
        })
        .then(function (response) {
          console.log(response.data);
          if (response.data.hasOwnProperty("token")) {
            that.token = response.data.token;
            localStorage.setItem("token", that.token);
            that.$router
              .push({
                name: "page",
                params: {
                  token: that.token,
                },
              })
              .catch((err) => {
                console.log(err);
              });
            localStorage.setItem('myAccount',account);
            window.open("/#/firstpage", (name = "_self"));
          } else {
            alert(response.data.errmsg);
          }
        });
    },
    goForget: function (event) {
      this.isForgetShow = true;
      this.isLoginShow = false;
    },
    goLogin: function (event) {
      let name = this.$refs.registerName.value;
      let account = this.$refs.registerAccount.value;
      let password = this.$refs.registerPassword.value;
      console.log(account + " " + name + " " + password);
      if (name == "" || account == "" || password == "") {
        alert("不能输入空的内容");
        this.isForgetShow = false;
        this.isLoginShow = true;
        // return false;
      } else {
        this.$axios
          .post("/user/loginUpByAccount", null, {
            params: {
              userName: name,
              userAccount: account,
              userPassword: password,
              userSex: 1,
              userBirthday: "1970-1-1",
              userPhoto: "",
            },
          })
          .then(function (response) {
            if (response.data) {
              alert("注册成功");
            } else {
              alert("用户名或密码不符合规范");
            }
          });
      }

      this.isForgetShow = false;
      this.isLoginShow = true;
    },
    goRegister: function (event) {
      this.isForgetShow = false;
      this.isLoginShow = false;
      this.isRegisterShow = true;
    },
  },
};
</script>

<style scope>
#login {
  margin: 150px;
  position: relative;
  border: 2px solid white;
  border-radius: 10px;
  box-shadow: 2px 2px 5px #000;
}
.box1 {
  display: flex;
  flex-direction: row;
  justify-content: left;
  margin-right: 10px;
}
.box2 {
  margin-top: 25px;
  margin-bottom: 10px;
  display: flex;
  flex-direction: column;
  justify-content: center;
  align-items: center;
}
.box3 {
  margin-top: 25px;
  margin-bottom: 5px;
  padding-left: 200px;
}
</style>