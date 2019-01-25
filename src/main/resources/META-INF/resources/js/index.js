/**
 * Created by dingxy on 2019/1/24.
 */
Vue.config.devtools = true

var app = new Vue({
    el: '#app',
    data: {
        message: 'Hello Vue!',
        columns: [
            {title: 'Index', prop: '$index', width: 100},
            {title: 'ID', prop: 'id', width: 100, sort: 'auto'},
            {title: 'Name', prop: 'name', sort: 'auto'},
            {title: 'Age', prop: 'age', sort: 'auto'},
            {title: 'Address', prop: 'address'},
        ],
        datas: [],
    },
    method: {},
    mounted: function () {
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
                    this.datas = body
                })
            }
        })
    }
});
