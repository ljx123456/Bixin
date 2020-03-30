package com.example.shadow.heartrecreation.ui.main.mvp.bean;

import java.util.List;

public class CityListBean {
//    /**
//     * code : 0
//     * message : 请求成功.
//     * data : [{"cityId":1,"cityName":"成都"}]
//     */
//
//    private int code;
//    private String message;
//    private List<DataBean> data;
//
//    public int getCode() {
//        return code;
//    }
//
//    public void setCode(int code) {
//        this.code = code;
//    }
//
//    public String getMessage() {
//        return message;
//    }
//
//    public void setMessage(String message) {
//        this.message = message;
//    }
//
//    public List<DataBean> getData() {
//        return data;
//    }
//
//    public void setData(List<DataBean> data) {
//        this.data = data;
//    }
//
//    public static class DataBean {
//        /**
//         * cityId : 1
//         * cityName : 成都
//         */
//
//        private int cityId;
//        private String cityName;
//
//        public int getCityId() {
//            return cityId;
//        }
//
//        public void setCityId(int cityId) {
//            this.cityId = cityId;
//        }
//
//        public String getCityName() {
//            return cityName;
//        }
//
//        public void setCityName(String cityName) {
//            this.cityName = cityName;
//        }
//    }


    /**
     * code : 0
     * message : 请求成功.
     * data : {"citys":[{"cityId":786,"cityName":"阿坝"},{"cityId":865,"cityName":"阿克苏"},{"cityId":873,"cityName":"阿拉尔"},{"cityId":547,"cityName":"阿拉善盟"},{"cityId":871,"cityName":"阿勒泰"},{"cityId":819,"cityName":"阿里"},{"cityId":829,"cityName":"安康"},{"cityId":616,"cityName":"安庆"},{"cityId":792,"cityName":"安顺"}],"allCity":[{"acronym":"A","citys":[{"cityId":786,"cityName":"阿坝"},{"cityId":865,"cityName":"阿克苏"},{"cityId":873,"cityName":"阿拉尔"},{"cityId":547,"cityName":"阿拉善盟"},{"cityId":871,"cityName":"阿勒泰"},{"cityId":819,"cityName":"阿里"},{"cityId":829,"cityName":"安康"},{"cityId":616,"cityName":"安庆"},{"cityId":792,"cityName":"安顺"},{"cityId":667,"cityName":"安阳"},{"cityId":550,"cityName":"鞍山"},{"cityId":903,"cityName":"澳门"}]},{"acronym":"B","citys":[{"cityId":543,"cityName":"巴彦淖尔"},{"cityId":864,"cityName":"巴音郭楞"},{"cityId":784,"cityName":"巴中"},{"cityId":569,"cityName":"白城"},{"cityId":759,"cityName":"白沙"},{"cityId":567,"cityName":"白山"},{"cityId":834,"cityName":"白银"},{"cityId":742,"cityName":"百色"},{"cityId":611,"cityName":"蚌埠"},{"cityId":537,"cityName":"包头"},{"cityId":823,"cityName":"宝鸡"},{"cityId":519,"cityName":"保定"},{"cityId":801,"cityName":"保山"},{"cityId":763,"cityName":"保亭"},{"cityId":737,"cityName":"北海"},{"cityId":512,"cityName":"北京"},{"cityId":552,"cityName":"本溪"},{"cityId":795,"cityName":"毕节"},{"cityId":661,"cityName":"滨州"},{"cityId":623,"cityName":"亳州"},{"cityId":863,"cityName":"博尔塔拉"}]},{"acronym":"C","citys":[{"cityId":522,"cityName":"沧州"},{"cityId":815,"cityName":"昌都"},{"cityId":862,"cityName":"昌吉"},{"cityId":760,"cityName":"昌江"},{"cityId":704,"cityName":"常德"},{"cityId":588,"cityName":"常州"},{"cityId":621,"cityName":"巢湖"},{"cityId":560,"cityName":"朝阳"},{"cityId":730,"cityName":"潮州"},{"cityId":707,"cityName":"郴州"},{"cityId":1,"cityName":"成都"},{"cityId":521,"cityName":"承德"},{"cityId":757,"cityName":"澄迈"},{"cityId":624,"cityName":"池州"},{"cityId":539,"cityName":"赤峰"},{"cityId":746,"cityName":"崇左"},{"cityId":618,"cityName":"滁州"},{"cityId":806,"cityName":"楚雄"}]},{"acronym":"D","citys":[{"cityId":782,"cityName":"达州"},{"cityId":810,"cityName":"大理"},{"cityId":549,"cityName":"大连"},{"cityId":576,"cityName":"大庆"},{"cityId":526,"cityName":"大同"},{"cityId":583,"cityName":"大兴安岭"},{"cityId":553,"cityName":"丹东"},{"cityId":751,"cityName":"儋州"},{"cityId":811,"cityName":"德宏"},{"cityId":772,"cityName":"德阳"},{"cityId":659,"cityName":"德州"},{"cityId":813,"cityName":"迪庆"},{"cityId":755,"cityName":"定安"},{"cityId":841,"cityName":"定西"},{"cityId":754,"cityName":"东方"},{"cityId":728,"cityName":"东莞"},{"cityId":650,"cityName":"东营"}]},{"acronym":"E","citys":[{"cityId":541,"cityName":"鄂尔多斯"},{"cityId":686,"cityName":"鄂州"},{"cityId":693,"cityName":"恩施"}]},{"acronym":"F","citys":[{"cityId":738,"cityName":"防城港"},{"cityId":717,"cityName":"佛山"},{"cityId":626,"cityName":"福州"},{"cityId":551,"cityName":"抚顺"},{"cityId":644,"cityName":"抚州"},{"cityId":556,"cityName":"阜新"},{"cityId":619,"cityName":"阜阳"}]},{"acronym":"G","citys":[{"cityId":844,"cityName":"甘南"},{"cityId":787,"cityName":"甘孜"},{"cityId":641,"cityName":"赣州"},{"cityId":877,"cityName":"高雄"},{"cityId":895,"cityName":"高雄"},{"cityId":856,"cityName":"固原"},{"cityId":781,"cityName":"广安"},{"cityId":774,"cityName":"广元"},{"cityId":712,"cityName":"广州"},{"cityId":740,"cityName":"贵港"},{"cityId":789,"cityName":"贵阳"},{"cityId":735,"cityName":"桂林"},{"cityId":850,"cityName":"果洛"}]},{"acronym":"H","citys":[{"cityId":571,"cityName":"哈尔滨"},{"cityId":861,"cityName":"哈密"},{"cityId":847,"cityName":"海北"},{"cityId":846,"cityName":"海东"},{"cityId":747,"cityName":"海口"},{"cityId":849,"cityName":"海南"},{"cityId":905,"cityName":"海外"},{"cityId":852,"cityName":"海西"},{"cityId":517,"cityName":"邯郸"},{"cityId":827,"cityName":"汉中"},{"cityId":598,"cityName":"杭州"},{"cityId":609,"cityName":"合肥"},{"cityId":868,"cityName":"和田"},{"cityId":744,"cityName":"河池"},{"cityId":725,"cityName":"河源"},{"cityId":662,"cityName":"菏泽"},{"cityId":743,"cityName":"贺州"},{"cityId":668,"cityName":"鹤壁"},{"cityId":574,"cityName":"鹤岗"},{"cityId":581,"cityName":"黑河"},{"cityId":524,"cityName":"衡水"},{"cityId":701,"cityName":"衡阳"},{"cityId":807,"cityName":"红河"},{"cityId":536,"cityName":"呼和浩特"},{"cityId":542,"cityName":"呼伦贝尔"},{"cityId":602,"cityName":"湖州"},{"cityId":561,"cityName":"葫芦岛"},{"cityId":898,"cityName":"花莲"},{"cityId":709,"cityName":"怀化"},{"cityId":592,"cityName":"淮安"},{"cityId":614,"cityName":"淮北"},{"cityId":612,"cityName":"淮南"},{"cityId":690,"cityName":"黄冈"},{"cityId":848,"cityName":"黄南"},{"cityId":617,"cityName":"黄山"},{"cityId":682,"cityName":"黄石"},{"cityId":722,"cityName":"惠州"}]},{"acronym":"J","citys":[{"cityId":573,"cityName":"鸡西"},{"cityId":882,"cityName":"基隆"},{"cityId":642,"cityName":"吉安"},{"cityId":563,"cityName":"吉林"},{"cityId":646,"cityName":"济南"},{"cityId":653,"cityName":"济宁"},{"cityId":671,"cityName":"济源"},{"cityId":578,"cityName":"佳木斯"},{"cityId":601,"cityName":"嘉兴"},{"cityId":884,"cityName":"嘉义"},{"cityId":892,"cityName":"嘉义"},{"cityId":832,"cityName":"嘉峪关"},{"cityId":718,"cityName":"江门"},{"cityId":670,"cityName":"焦作"},{"cityId":731,"cityName":"揭阳"},{"cityId":833,"cityName":"金昌"},{"cityId":604,"cityName":"金华"},{"cityId":880,"cityName":"金门"},{"cityId":554,"cityName":"锦州"},{"cityId":529,"cityName":"晋城"},{"cityId":531,"cityName":"晋中"},{"cityId":687,"cityName":"荆门"},{"cityId":689,"cityName":"荆州"},{"cityId":636,"cityName":"景德镇"},{"cityId":638,"cityName":"九江"},{"cityId":901,"cityName":"九龙"},{"cityId":839,"cityName":"酒泉"}]},{"acronym":"K","citys":[{"cityId":867,"cityName":"喀什"},{"cityId":664,"cityName":"开封"},{"cityId":859,"cityName":"克拉玛依"},{"cityId":866,"cityName":"克孜勒苏柯尔克孜"},{"cityId":798,"cityName":"昆明"}]},{"acronym":"L","citys":[{"cityId":814,"cityName":"拉萨"},{"cityId":745,"cityName":"来宾"},{"cityId":657,"cityName":"莱芜"},{"cityId":831,"cityName":"兰州"},{"cityId":523,"cityName":"廊坊"},{"cityId":761,"cityName":"乐东"},{"cityId":777,"cityName":"乐山"},{"cityId":904,"cityName":"离岛"},{"cityId":803,"cityName":"丽江"},{"cityId":608,"cityName":"丽水"},{"cityId":591,"cityName":"连云港"},{"cityId":788,"cityName":"凉山"},{"cityId":557,"cityName":"辽阳"},{"cityId":565,"cityName":"辽源"},{"cityId":660,"cityName":"聊城"},{"cityId":820,"cityName":"林芝"},{"cityId":805,"cityName":"临沧"},{"cityId":534,"cityName":"临汾"},{"cityId":758,"cityName":"临高"},{"cityId":843,"cityName":"临夏"},{"cityId":658,"cityName":"临沂"},{"cityId":762,"cityName":"陵水"},{"cityId":734,"cityName":"柳州"},{"cityId":622,"cityName":"六安"},{"cityId":790,"cityName":"六盘水"},{"cityId":633,"cityName":"龙岩"},{"cityId":842,"cityName":"陇南"},{"cityId":710,"cityName":"娄底"},{"cityId":771,"cityName":"泸州"},{"cityId":535,"cityName":"吕梁"},{"cityId":665,"cityName":"洛阳"},{"cityId":674,"cityName":"漯河"}]},{"acronym":"M","citys":[{"cityId":613,"cityName":"马鞍山"},{"cityId":720,"cityName":"茂名"},{"cityId":779,"cityName":"眉山"},{"cityId":723,"cityName":"梅州"},{"cityId":773,"cityName":"绵阳"},{"cityId":889,"cityName":"苗栗"},{"cityId":580,"cityName":"牡丹江"}]},{"acronym":"N","citys":[{"cityId":776,"cityName":"内江"},{"cityId":818,"cityName":"那曲"},{"cityId":635,"cityName":"南昌"},{"cityId":778,"cityName":"南充"},{"cityId":585,"cityName":"南京"},{"cityId":733,"cityName":"南宁"},{"cityId":632,"cityName":"南平"},{"cityId":766,"cityName":"南沙"},{"cityId":590,"cityName":"南通"},{"cityId":881,"cityName":"南投"},{"cityId":676,"cityName":"南阳"},{"cityId":599,"cityName":"宁波"},{"cityId":634,"cityName":"宁德"},{"cityId":812,"cityName":"怒江"}]},{"acronym":"P","citys":[{"cityId":770,"cityName":"攀枝花"},{"cityId":558,"cityName":"盘锦"},{"cityId":899,"cityName":"澎湖"},{"cityId":666,"cityName":"平顶山"},{"cityId":838,"cityName":"平凉"},{"cityId":896,"cityName":"屏东"},{"cityId":637,"cityName":"萍乡"},{"cityId":628,"cityName":"莆田"},{"cityId":672,"cityName":"濮阳"}]},{"acronym":"Q","citys":[{"cityId":579,"cityName":"七台河"},{"cityId":572,"cityName":"齐齐哈尔"},{"cityId":695,"cityName":"潜江"},{"cityId":796,"cityName":"黔东"},{"cityId":797,"cityName":"黔南"},{"cityId":794,"cityName":"黔西"},{"cityId":739,"cityName":"钦州"},{"cityId":516,"cityName":"秦皇岛"},{"cityId":647,"cityName":"青岛"},{"cityId":727,"cityName":"清远"},{"cityId":840,"cityName":"庆阳"},{"cityId":750,"cityName":"琼海"},{"cityId":764,"cityName":"琼中"},{"cityId":799,"cityName":"曲靖"},{"cityId":605,"cityName":"衢州"},{"cityId":630,"cityName":"泉州"}]},{"acronym":"R","citys":[{"cityId":817,"cityName":"日喀则"},{"cityId":656,"cityName":"日照"}]},{"acronym":"S","citys":[{"cityId":675,"cityName":"三门峡"},{"cityId":629,"cityName":"三明"},{"cityId":748,"cityName":"三亚"},{"cityId":816,"cityName":"山南"},{"cityId":716,"cityName":"汕头"},{"cityId":724,"cityName":"汕尾"},{"cityId":830,"cityName":"商洛"},{"cityId":677,"cityName":"商丘"},{"cityId":584,"cityName":"上海"},{"cityId":645,"cityName":"上饶"},{"cityId":713,"cityName":"韶关"},{"cityId":702,"cityName":"邵阳"},{"cityId":603,"cityName":"绍兴"},{"cityId":714,"cityName":"深圳"},{"cityId":697,"cityName":"神农架林区"},{"cityId":548,"cityName":"沈阳"},{"cityId":683,"cityName":"十堰"},{"cityId":872,"cityName":"石河子"},{"cityId":514,"cityName":"石家庄"},{"cityId":854,"cityName":"石嘴山"},{"cityId":575,"cityName":"双鸭山"},{"cityId":530,"cityName":"朔州"},{"cityId":804,"cityName":"思茅"},{"cityId":564,"cityName":"四平"},{"cityId":568,"cityName":"松原"},{"cityId":589,"cityName":"苏州"},{"cityId":597,"cityName":"宿迁"},{"cityId":620,"cityName":"宿州"},{"cityId":582,"cityName":"绥化"},{"cityId":692,"cityName":"随州"},{"cityId":775,"cityName":"遂宁"},{"cityId":627,"cityName":"厦门"}]},{"acronym":"T","citys":[{"cityId":870,"cityName":"塔城"},{"cityId":876,"cityName":"台北"},{"cityId":885,"cityName":"台北"},{"cityId":897,"cityName":"台东"},{"cityId":878,"cityName":"台南"},{"cityId":894,"cityName":"台南"},{"cityId":879,"cityName":"台中"},{"cityId":890,"cityName":"台中"},{"cityId":607,"cityName":"台州"},{"cityId":525,"cityName":"太原"},{"cityId":654,"cityName":"泰安"},{"cityId":596,"cityName":"泰州"},{"cityId":515,"cityName":"唐山"},{"cityId":888,"cityName":"桃园"},{"cityId":513,"cityName":"天津"},{"cityId":696,"cityName":"天门"},{"cityId":835,"cityName":"天水"},{"cityId":559,"cityName":"铁岭"},{"cityId":566,"cityName":"通化"},{"cityId":540,"cityName":"通辽"},{"cityId":822,"cityName":"铜川"},{"cityId":615,"cityName":"铜陵"},{"cityId":793,"cityName":"铜仁"},{"cityId":874,"cityName":"图木舒克"},{"cityId":860,"cityName":"吐鲁番"},{"cityId":756,"cityName":"屯昌"}]},{"acronym":"W","citys":[{"cityId":753,"cityName":"万宁"},{"cityId":655,"cityName":"威海"},{"cityId":652,"cityName":"潍坊"},{"cityId":825,"cityName":"渭南"},{"cityId":600,"cityName":"温州"},{"cityId":752,"cityName":"文昌"},{"cityId":808,"cityName":"文山"},{"cityId":538,"cityName":"乌海"},{"cityId":544,"cityName":"乌兰察布"},{"cityId":858,"cityName":"乌鲁木齐"},{"cityId":586,"cityName":"无锡"},{"cityId":855,"cityName":"吴忠"},{"cityId":610,"cityName":"芜湖"},{"cityId":736,"cityName":"梧州"},{"cityId":875,"cityName":"五家渠"},{"cityId":749,"cityName":"五指山"},{"cityId":681,"cityName":"武汉"},{"cityId":836,"cityName":"武威"}]},{"acronym":"X","citys":[{"cityId":821,"cityName":"西安"},{"cityId":845,"cityName":"西宁"},{"cityId":765,"cityName":"西沙"},{"cityId":809,"cityName":"西双版纳"},{"cityId":546,"cityName":"锡林郭勒盟"},{"cityId":694,"cityName":"仙桃"},{"cityId":691,"cityName":"咸宁"},{"cityId":824,"cityName":"咸阳"},{"cityId":900,"cityName":"香港岛"},{"cityId":700,"cityName":"湘潭"},{"cityId":711,"cityName":"湘西"},{"cityId":685,"cityName":"襄樊"},{"cityId":688,"cityName":"孝感"},{"cityId":533,"cityName":"忻州"},{"cityId":902,"cityName":"新界"},{"cityId":669,"cityName":"新乡"},{"cityId":639,"cityName":"新余"},{"cityId":883,"cityName":"新竹"},{"cityId":887,"cityName":"新竹"},{"cityId":678,"cityName":"信阳"},{"cityId":545,"cityName":"兴安盟"},{"cityId":518,"cityName":"邢台"},{"cityId":587,"cityName":"徐州"},{"cityId":673,"cityName":"许昌"},{"cityId":625,"cityName":"宣城"}]},{"acronym":"Y","citys":[{"cityId":783,"cityName":"雅安"},{"cityId":651,"cityName":"烟台"},{"cityId":826,"cityName":"延安"},{"cityId":570,"cityName":"延边"},{"cityId":593,"cityName":"盐城"},{"cityId":594,"cityName":"扬州"},{"cityId":726,"cityName":"阳江"},{"cityId":527,"cityName":"阳泉"},{"cityId":577,"cityName":"伊春"},{"cityId":869,"cityName":"伊犁"},{"cityId":780,"cityName":"宜宾"},{"cityId":684,"cityName":"宜昌"},{"cityId":643,"cityName":"宜春"},{"cityId":886,"cityName":"宜兰"},{"cityId":706,"cityName":"益阳"},{"cityId":853,"cityName":"银川"},{"cityId":640,"cityName":"鹰潭"},{"cityId":555,"cityName":"营口"},{"cityId":708,"cityName":"永州"},{"cityId":828,"cityName":"榆林"},{"cityId":741,"cityName":"玉林"},{"cityId":851,"cityName":"玉树"},{"cityId":800,"cityName":"玉溪"},{"cityId":703,"cityName":"岳阳"},{"cityId":732,"cityName":"云浮"},{"cityId":893,"cityName":"云林"},{"cityId":532,"cityName":"运城"}]},{"acronym":"Z","citys":[{"cityId":562,"cityName":"长春"},{"cityId":698,"cityName":"长沙"},{"cityId":528,"cityName":"长治"},{"cityId":649,"cityName":"枣庄"},{"cityId":719,"cityName":"湛江"},{"cityId":705,"cityName":"张家界"},{"cityId":520,"cityName":"张家口"},{"cityId":837,"cityName":"张掖"},{"cityId":891,"cityName":"彰化"},{"cityId":631,"cityName":"漳州"},{"cityId":802,"cityName":"昭通"},{"cityId":721,"cityName":"肇庆"},{"cityId":595,"cityName":"镇江"},{"cityId":663,"cityName":"郑州"},{"cityId":767,"cityName":"中沙"},{"cityId":729,"cityName":"中山"},{"cityId":857,"cityName":"中卫"},{"cityId":606,"cityName":"舟山"},{"cityId":679,"cityName":"周口"},{"cityId":699,"cityName":"株洲"},{"cityId":715,"cityName":"珠海"},{"cityId":680,"cityName":"驻马店"},{"cityId":785,"cityName":"资阳"},{"cityId":648,"cityName":"淄博"},{"cityId":769,"cityName":"自贡"},{"cityId":791,"cityName":"遵义"}]}]}
     */

    private int code;
    private String message;
    private DataBean data;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    public static class DataBean {
        private List<CitysBean> citys;
        private List<AllCityBean> allCity;

        public List<CitysBean> getCitys() {
            return citys;
        }

        public void setCitys(List<CitysBean> citys) {
            this.citys = citys;
        }

        public List<AllCityBean> getAllCity() {
            return allCity;
        }

        public void setAllCity(List<AllCityBean> allCity) {
            this.allCity = allCity;
        }

        public static class CitysBean {
            /**
             * cityId : 786
             * cityName : 阿坝
             */

            private int cityId;
            private String cityName;
            private boolean flag;

            public boolean isFlag() {
                return flag;
            }

            public void setFlag(boolean flag) {
                this.flag = flag;
            }

            public int getCityId() {
                return cityId;
            }

            public void setCityId(int cityId) {
                this.cityId = cityId;
            }

            public String getCityName() {
                return cityName;
            }

            public void setCityName(String cityName) {
                this.cityName = cityName;
            }
        }

        public static class AllCityBean {
            /**
             * acronym : A
             * citys : [{"cityId":786,"cityName":"阿坝"},{"cityId":865,"cityName":"阿克苏"},{"cityId":873,"cityName":"阿拉尔"},{"cityId":547,"cityName":"阿拉善盟"},{"cityId":871,"cityName":"阿勒泰"},{"cityId":819,"cityName":"阿里"},{"cityId":829,"cityName":"安康"},{"cityId":616,"cityName":"安庆"},{"cityId":792,"cityName":"安顺"},{"cityId":667,"cityName":"安阳"},{"cityId":550,"cityName":"鞍山"},{"cityId":903,"cityName":"澳门"}]
             */

            private String acronym;
            private List<CitysBeanX> citys;

            public String getAcronym() {
                return acronym;
            }

            public void setAcronym(String acronym) {
                this.acronym = acronym;
            }

            public List<CitysBeanX> getCitys() {
                return citys;
            }

            public void setCitys(List<CitysBeanX> citys) {
                this.citys = citys;
            }

            public static class CitysBeanX {
                /**
                 * cityId : 786
                 * cityName : 阿坝
                 */

                private int cityId;
                private String cityName;

                public int getCityId() {
                    return cityId;
                }

                public void setCityId(int cityId) {
                    this.cityId = cityId;
                }

                public String getCityName() {
                    return cityName;
                }

                public void setCityName(String cityName) {
                    this.cityName = cityName;
                }
            }
        }
    }

}
