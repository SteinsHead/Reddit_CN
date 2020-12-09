<template>
  <div id="change-message">
    <el-form ref="form" :model="form" label-width="100px">
      <el-from-item label="上传头像" style="margin: 10px">
        <el-upload
          action=""
          list-type="picture-card"
          :http-request="sendRealRequest"
          :file-list="fileList"
          :on-preview="handlePictureCardPreview"
          :on-remove="handleRemove"
          :on-success="uploadSuccess"
          :on-error="uploadError"
        >
        </el-upload>
      </el-from-item>
      <el-form-item label="你的昵称">
        <el-input v-model="form.name"></el-input>
      </el-form-item>
      <el-form-item label="你的性别">
        <el-select v-model="form.sex" placeholder="请选择你的性别">
          <el-option label="男" value="1"></el-option>
          <el-option label="女" value="0"></el-option>
        </el-select>
      </el-form-item>
      <el-form-item label="你的生日">
        <el-col>
          <el-date-picker
            type="date"
            placeholder="请选择你的生日"
            v-model="form.date"
            value-format="yyyy-M-d"
            style="width: 100%"
          ></el-date-picker>
        </el-col>
      </el-form-item>
      <el-form-item label="自我介绍">
        <el-input type="textarea" v-model="form.intro"></el-input>
      </el-form-item>
      <el-form-item>
        <el-button type="primary" @click="onSubmit">更新信息</el-button>
      </el-form-item>
    </el-form>
  </div>
</template>

<script>
export default {
  name: "changeMsg",
  data() {
    return {
      form: {
        name: "",
        sex: "",
        date: "",
        intro: "",
      },
      fileList: [],
      photoUrl: "",
    };
  },
  props: {
      
  },
  methods: {
    sendRealRequest(params) {
      console.log("param is " + params.file.type);
      let that = this;
      let file = params.file;
      that.uploadFile(file);
      console.log("hh");
    },
    uploadFile(file) {
      let that = this;
      let param = new FormData();
      param.append("file", file);
      that
        .axios({
          method: "post",
          url: "/uploadPhoto",
          data: param,
          timeout:2000,
          headers: {
            "Content-Type": "multipart/form-data",
            token: localStorage.getItem('token'),
          },
        })
        .then(function (response) {
          console.log(response);
          console.log(response.data);
          that.photoUrl = response.data;
        })
        .catch(function (error) {
          console.log(error);
        });
    },
    onSubmit() {
      console.log("submit!");
      let that = this;
      that
        .axios({
          method: "post",
          url: "/user/updateUserInformation",
          params: {
            userName: that.form.name,
            userSex: Number(that.form.sex),
            userBirthday: that.form.date,
            userPhoto: that.photoUrl,
            userIntroduce: that.form.intro,
          },
          headers: {
            token: localStorage.getItem('token'),
          },
        })
        .then(function (response) {
          console.log(response);
        })
        .catch(function (error) {
          console.log(error);
        });
      setTimeout(function () {
        location.reload();
      }, 10000);
    },
    handleRemove(file) {
      console.log(file);
    },
    handlePictureCardPreview(file) {
      console.log(file);
    },
    handleDownload(file) {
      console.log(file);
    },
    uploadSuccess(response, file, fileList) {
      let that = this;
      console.log("上传文件成功response" + response);
      console.log("上传文件成功file" + file);
      console.log("上传文件成功fileList" + fileList);
      that.fileList.push(response);
    },
    uploadError(err, file, fileList) {
      console.log("上传文件失败err" + err);
      console.log("上传文件失败file" + file);
      console.log("上传文件失败fileList" + fileList);
    },
  },
};
</script>

<style>
</style>