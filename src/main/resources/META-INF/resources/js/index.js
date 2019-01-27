/**
 * Created by dingxy on 2019/1/24.
 */
Vue.config.devtools = true

var app = new Vue({
    el: '#app',
    data: {
        message: 'Hello Vue!',
        columns: [
            // {title: 'Index', prop: '$index', width: 100},
            // {title: 'ID', prop: 'id', width: 100, sort: 'auto'},
            {title: '姓名', prop: 'name', sort: 'auto'},
            {title: '手机号', prop: 'mobile', sort: 'auto'},
            {title: '生日', prop: 'birthday'},
            {title: '毕业学校', prop: 'guaduatedSchool'},
            {title: '专业', prop: 'major'},
            {title: '第二专业', prop: 'doubleMajor'},
            {title: '升学学校', prop: 'upgradedSchool'},
            {title: '所在城市', prop: 'city'},
            {title: '公司', prop: 'company'},
        ],
        datas: [],
    },
    method: {},
    mounted: function () {
        let that = this
        let myHeaders = new Headers();
        myHeaders.append('Content-Type', 'application/json');
        let req = new Request("/classmates/list", {
            method: 'POST',
            body: JSON.stringify({
                page: 1,
                size: 10
            }),
            headers: myHeaders
        });
        fetch(req).then(function (resp) {
            if (resp.status == 200 && resp.ok) {
                resp.json().then(body => {
                    that.datas = body
                })
            }
        })
    }
});
