package com.android.fuayng.mhome.bean;

import java.util.List;

/**
 * 作者：SYC on 2017/3/24 17:34
 * 类名：
 * 用途：
 */

public class HomeDataBean {

    /**
     * data : [{"displayname":[{"name":"测试内容j4zt","lan":"测试内容eoj3"}],"main image":[{"type":"main","size":"_1024_768","link":"http://www.yahoo.com/_1024_768/banner_icon.png"}],"action":[{"body":"NULL","uri":"mis/user/12345/category/c11","type":"GET"}],"content":"null","type":"uri","name":"Banner"},{"displayname":[{"name":"测试内容j4zt","lan":"测试内容eoj3"}],"main image":[{"type":"main","size":"_240_480","link":"http://www.yahoo.com/_240_480/banner_icon.png"}],"action":[{"body":"NULL","uri":"mis/user/12345/category/c11","type":"GET"}],"content":"null","type":"uri","name":"Want to Buy"},{"displayname":[{"name":"测试内容j4zt","lan":"测试内容eoj3"}],"main image":[{"type":"main","size":"_1024_768","link":"http://www.yahoo.com/_1024_768/banner_icon.png"}],"action":[{"body":"NULL","uri":"mis/user/12345/category/c11","type":"GET"}],"content":"null","type":"uri","name":"Want to Rent"},{"displayname":[{"name":"测试内容j4zt","lan":"测试内容eoj3"}],"main image":[{"type":"main","size":"_240_480","link":"http://www.yahoo.com/_240_480/banner_icon.png"}],"action":[{"body":"NULL","uri":"mis/user/12345/category/c11","type":"GET"}],"content":"null","type":"uri","name":"Customized"},{"displayname":[{"name":"测试内容j4zt","lan":"测试内容eoj3"}],"main image":[{"type":"main","size":"_1024_768","link":"http://www.yahoo.com/_1024_768/banner_icon.png"}],"action":[{"body":"NULL","uri":"mis/user/12345/category/c11","type":"GET"}],"content":"null","type":"uri","name":"Uploaded"},{"displayname":[{"name":"测试内容j4zt","lan":"测试内容eoj3"}],"main image":[{"type":"main","size":"_240_480","link":"http://www.yahoo.com/_240_480/banner_icon.png"}],"action":[{"body":"NULL","uri":"mis/user/12345/category/c11","type":"GET"}],"content":"null","type":"uri","name":"New"},{"displayname":[{"name":"测试内容j4zt","lan":"测试内容eoj3"}],"main image":[{"type":"main","size":"_1024_768","link":"http://www.yahoo.com/_1024_768/banner_icon.png"}],"action":[{"body":"NULL","uri":"mis/user/12345/category/c11","type":"GET"}],"content":"null","type":"uri","name":"Buy"},{"displayname":[{"name":"测试内容j4zt","lan":"测试内容eoj3"}],"main image":[{"type":"main","size":"_240_480","link":"http://www.yahoo.com/_240_480/banner_icon.png"}],"action":[{"body":"NULL","uri":"mis/user/12345/category/c11","type":"GET"}],"content":"null","type":"uri","name":"Rent"},{"displayname":[{"name":"测试内容j4zt","lan":"测试内容eoj3"}],"main image":[{"type":"main","size":"_1024_768","link":"http://www.yahoo.com/_1024_768/banner_icon.png"}],"action":[{"body":"NULL","uri":"mis/user/12345/category/c11","type":"GET"}],"content":"null","type":"uri","name":"Best Buy"},{"displayname":[{"name":"测试内容j4zt","lan":"测试内容eoj3"}],"main image":[{"type":"main","size":"_240_480","link":"http://www.yahoo.com/_240_480/banner_icon.png"}],"action":[{"body":"NULL","uri":"mis/user/12345/category/c11","type":"GET"}],"content":"null","type":"uri","name":"Best Rent"}]
     * scode : 200
     * status : success
     */

    private String scode;
    private String status;
    private List<DataBean> data;

    // FIXME generate failure  field _$MainImage8
    public static class DataBean {
        /**
         * displayname : [{"name":"测试内容j4zt","lan":"测试内容eoj3"}]
         * main image : [{"type":"main","size":"_1024_768","link":"http://www.yahoo.com/_1024_768/banner_icon.png"}]
         * action : [{"body":"NULL","uri":"mis/user/12345/category/c11","type":"GET"}]
         * content : null
         * type : uri
         * name : Banner
         */

        private String content;
        private String type;
        private String name;
        private List<DisplaynameBean> displayname;
        private List<ActionBean> action;

        public String getContent() {
            return content;
        }

        public void setContent(String content) {
            this.content = content;
        }

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public List<DisplaynameBean> getDisplayname() {
            return displayname;
        }

        public void setDisplayname(List<DisplaynameBean> displayname) {
            this.displayname = displayname;
        }

        public static class DisplaynameBean {
            /**
             * name : 测试内容j4zt
             * lan : 测试内容eoj3
             */

            private String name;
            private String lan;

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

            public String getLan() {
                return lan;
            }

            public void setLan(String lan) {
                this.lan = lan;
            }
        }

        public static class MainimageBean {
            /**
             * type : main
             * size : _1024_768
             * link : http://www.yahoo.com/_1024_768/banner_icon.png
             */

            private String type;
            private String size;
            private String link;

            public String getType() {
                return type;
            }

            public void setType(String type) {
                this.type = type;
            }

            public String getSize() {
                return size;
            }

            public void setSize(String size) {
                this.size = size;
            }

            public String getLink() {
                return link;
            }

            public void setLink(String link) {
                this.link = link;
            }
        }

        public static class ActionBean {
            /**
             * body : NULL
             * uri : mis/user/12345/category/c11
             * type : GET
             */

            private String body;
            private String uri;
            private String type;

            public String getBody() {
                return body;
            }

            public void setBody(String body) {
                this.body = body;
            }

            public String getUri() {
                return uri;
            }

            public void setUri(String uri) {
                this.uri = uri;
            }

            public String getType() {
                return type;
            }

            public void setType(String type) {
                this.type = type;
            }
        }
    }
}
