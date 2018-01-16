package com.zhou.turtle.bean;

/**
 * Created by zhou on 2017/12/6.
 */

public class UserBean {

    /**
     * error : 0
     * data : {"id":403,"username":"3232@qq.com","nickname":"edu9771403","status":1,"created_at":"2017-12-05 08:30:14","pic":null,"token_rongyun":"oMhQCbJwLr5yz68vBy1UXdEN9zq1MPVRJY5T9YJG6xC4CUiw8eT3U1xdPIXcP1BzgvFFdhfHllRAx8OCycXNOQ==","token":"42862f5c207f2b96f703636d441b934c","updated_at":"2017-12-06 09:03:31"}
     */

    private int error;
    private String msg;
    private DataBean data;

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public int getError() {
        return error;
    }

    public void setError(int error) {
        this.error = error;
    }

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    public static class DataBean {
        /**
         * id : 403
         * username : 3232@qq.com
         * nickname : edu9771403
         * status : 1
         * created_at : 2017-12-05 08:30:14
         * pic : null
         * token_rongyun : oMhQCbJwLr5yz68vBy1UXdEN9zq1MPVRJY5T9YJG6xC4CUiw8eT3U1xdPIXcP1BzgvFFdhfHllRAx8OCycXNOQ==
         * token : 42862f5c207f2b96f703636d441b934c
         * updated_at : 2017-12-06 09:03:31
         */

        private int id;
        private String username;
        private String nickname;
        private int status;
        private String created_at;
        private String pic;
        private String token_rongyun;
        private String token;
        private String updated_at;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getUsername() {
            return username;
        }

        public void setUsername(String username) {
            this.username = username;
        }

        public String getNickname() {
            return nickname;
        }

        public void setNickname(String nickname) {
            this.nickname = nickname;
        }

        public int getStatus() {
            return status;
        }

        public void setStatus(int status) {
            this.status = status;
        }

        public String getCreated_at() {
            return created_at;
        }

        public void setCreated_at(String created_at) {
            this.created_at = created_at;
        }

        public String getPic() {
            return pic;
        }

        public void setPic(String pic) {
            this.pic = pic;
        }

        public String getToken_rongyun() {
            return token_rongyun;
        }

        public void setToken_rongyun(String token_rongyun) {
            this.token_rongyun = token_rongyun;
        }

        public String getToken() {
            return token;
        }

        public void setToken(String token) {
            this.token = token;
        }

        public String getUpdated_at() {
            return updated_at;
        }

        public void setUpdated_at(String updated_at) {
            this.updated_at = updated_at;
        }
    }
}
