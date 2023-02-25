

function fun(id, url, parameter, obj, reset2, resetSelect) {
  layui.use(['element', 'layer', 'util'], function () {
    var element = layui.element
      , layer = layui.layer
      , util = layui.util
      , table = layui.table
      , $ = layui.$;

    let item = document.querySelector('.layui-form-item').querySelectorAll('.block')
    // 表单查询/Query

    if (item.length == 1) {
      var inputBox = item[0].children[0]
    } else if (item.length == 2) {
      var inputBox = item[0].children[0]
      var inputBox2 = item[1].children[0]
    } else if (item.length == 3) {
      var inputBox = item[0].children[0]
      var inputBox2 = item[1].children[0]
      var inputBox3 = item[2].children[0]
    }
    let inquire = document.querySelector('#inquire')
    inquire.addEventListener('click', function () {
      console.log(inputBox)
      try {

        if (item.length == 1) {
          obj[Object.keys(obj)[3]] = inputBox.value
        } else if (item.length == 2) {
          obj[Object.keys(obj)[3]] = inputBox.value
          obj[Object.keys(obj)[4]] = inputBox2.value
        } else if (item.length == 3) {
          obj[Object.keys(obj)[3]] = inputBox.value
          obj[Object.keys(obj)[4]] = inputBox2.value
          obj[Object.keys(obj)[5]] = inputBox3.value
        }
        var str = Object.assign({}, obj)
      } catch (err) {
        console.log(err)
      }
      finally {
        console.log(str)
        // 删除/Del没有输入的参数
        Object.keys(str).forEach(item => {
          if (str[item] === '' || str[item] === null || str[item] === undefined) delete str[item]
        })
        table.reload(id, {
          where: str
        })
      }

    })


    // 表单重置/Reset
    let reset = document.querySelector('#reset')
    reset.addEventListener('click', function () {
      try {
        inputBox.value = ''
        inputBox2.value = ''
        inputBox3.value = ''
      } catch (err) {
        console.log(err)
      } finally {
        if (resetSelect) {
          //  循环清除下拉框里面的值 
          for (let value of resetSelect) {
            $(`#${value}`).val("");
            var select = 'dd[lay-value=' + '0' + ']';
            $(`#${value}`).siblings("div.layui-form-select").find('dl').find(select).click();
            //重新渲染下拉框
            layui.use('form', function () {
              var form = layui.form;
              form.render("select");
            });
          }
        }
      }
      table.reload(id, {
        where: reset2
      })
    })


    // 删除/Del按钮
    let deleteBtn = document.querySelector('#delete')
    deleteBtn.onclick = function () {
      console.log(1)
      let checkStatus = table.checkStatus(id).data;
      console.log(checkStatus[0].user_id)
      if (checkStatus.length >= 1) {
        layer.confirm('此操作将永远删除/Del该文件，是否继续', {
          btn: ['确定', '取消/Cancel'] //按钮
        }, async function () {
          for (let i = 0; i < checkStatus.length; i++) {
            let { data: res } = await axios.get(url, {
              params: {
                [parameter]: checkStatus[i][parameter]
              }
            })
            if (checkStatus[i].user_id) {
              let { data: res } = await axios.get('http://127.0.0.1:5000/api/user/del', {
                params: {
                  user_id: checkStatus[i].user_id
                }
              })
            }
          }
          // 重新渲染表格
          table.reload(id, {
            where: reset2
          })
          // 重置/Reset
          try {
            inputBox.value = ''
            inputBox2.value = ''
            inputBox3.value = ''
          } catch (err) {
            console.log(err)
          } finally {
            if (resetSelect) {
              //  循环清除下拉框里面的值 
              for (let value of resetSelect) {
                $(`#${value}`).val("");
                var select = 'dd[lay-value=' + '0' + ']';
                $(`#${value}`).siblings("div.layui-form-select").find('dl').find(select).click();
                //重新渲染下拉框
                layui.use('form', function () {
                  var form = layui.form;
                  form.render("select");
                });
              }
            }
          }
          table.reload(id, {
            where: reset2
          })
          layer.msg('删除/Del成功', { icon: 1 });
        }, function () {
          layer.msg('已取消/Cancel删除/Del');
        });
      }
    }
  })
}

// 下拉框函数的封装
async function init(url, id) {
  // 拿到单选框的父级节点
  var select = document.querySelector(`#${id}`)
  var op1 = document.createElement("option");
  op1.value = '0'
  select.appendChild(op1)
  // 收集数据 长度
  var count
  // 收集数据 数组
  var arr = []
  let { data: res } = await axios.get(url)
  count = res.result.count
  arr = res.result.list
  for (var i = 0; i < arr.length; i++) {
    // 创建节点
    var op = document.createElement("option");
    // 给节点赋值
    op.innerHTML = arr[i].name
    op.value = i + 1
    // 新增/Add节点
    select.appendChild(op)
    layui.form.render("select");
  }
}

// 下拉框函数的封装
async function inits(url, id) {
  // 拿到单选框的父级节点
  var select = document.querySelector(`#${id}`)
  var op1 = document.createElement("option");
  op1.value = '0'
  select.appendChild(op1)
  // 收集数据 长度
  var count
  // 收集数据 数组
  var arr = []
  let { data: res } = await axios.get(url)
  count = res.result.count
  arr = res.result.list
  for (var i = 0; i < arr.length; i++) {
    // 创建节点
    var op = document.createElement("option");
    // 给节点赋值
    op.innerHTML = arr[i][id]
    op.value = i + 1
    // 新增/Add节点
    select.appendChild(op)
    layui.form.render("select");
  }
}


// test c
function fell(arr, id) {
  // 拿到单选框的父级节点
  var select = document.querySelector(`#${id}`)
  var op1 = document.createElement("option");
  op1.value = '0'
  select.appendChild(op1)
  for (var i = 0; i < arr.length; i++) {
    // 创建节点
    var op = document.createElement("option");
    // 给节点赋值
    op.innerHTML = arr[i]
    op.value = i + 1
    // 新增/Add节点
    select.appendChild(op)
    layui.form.render("select");
  }
}

// 商家账号和卖家账号下拉框的封装

async function local(id, request, number) {
  // 拿到单选框的父级节点
  var select = document.querySelector(`#${id}`)
  console.log(select)
  var op1 = document.createElement("option");
  op1.value = '0'
  select.appendChild(op1)
  // 收集数据 长度
  var count
  // 收集数据 数组
  var arr = []
  let { data: res } = await axios.get("http://127.0.0.1:5000/api/user/get_list", {
    params: {
      user_group: request
    }
  })
  count = res.result.count
  arr = res.result.list
  for (var i = 0; i < arr.length; i++) {
    // 创建节点
    var op = document.createElement("option");
    // 自定义属性的操作
    op.setAttribute(number, arr[i].user_id);
    // 给节点赋值
    op.innerHTML = arr[i].nickname + '-' + arr[i].username
    op.value = i + 1
    // console.log(op);
    // 新增/Add节点
    select.appendChild(op)
    layui.form.render("select");
  }
}

function get_power(path, lists) {
  var list = lists;
  var obj;
  for (var i = 0; i < list.length; i++) {
    var o = list[i];
    if (o.path === path) {
      obj = o;
      break;
    }
  }
  return obj;
}

function page_title(path, id, lists) {
  let test = document.querySelector(`#${id}`)
  var o = get_power(path, lists);
  if (o) {
    test.innerHTML = o.page_title || o.mod_name;
  }
  return "";
}

