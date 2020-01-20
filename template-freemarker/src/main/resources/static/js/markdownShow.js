/**
 * 添加复制按钮
 * 添加到pre-code的后面
 */
function addCopyButton() {
    //获取所有的代码区域的pre元素节点
    const preElements = document.getElementsByTagName('pre');
    //遍历DOM（pre节点）节点
    for (let i = 0; i < preElements.length; i++) {
        //pre元素对象
        let preElement = preElements[i];
        //获取时间戳
        let time = new Date().getTime();
        //生成复制按钮
        let copyButtonElement = '<div class="codecopy-btn" data-title="复制" data-clipboard-action="copy" data-clipboard-target="#code_' + time + '"' +
            'onclick="onC(this);" onmouseout="mOut(this)">复制</div>';
        //找到code元素，并添加id属性，id的值和复制按钮的属性 data-clipboard-target 的值（去掉#符号后，注：data-clipboard-target的值就是元素选择器的值）是一样的
        preElement.firstChild.id = 'code_' + time; //setAttribute('id', 'code_' + time);
        //将复制按钮追加至页面
        let html = preElement.innerHTML + copyButtonElement;
        preElement.innerHTML = html;
    }
    /*初始化复制功能*/
    const clipboardJs = new ClipboardJS('.codecopy-btn'); //注意：ClipboardJS替代了Clipboard

    /*复制成功事件*/
    clipboardJs.on('success', function (e) {
        console.log(e);
    });
    /*复制失败事件*/
    clipboardJs.on('error', function (e) {
        console.log(e);
    });
}
/*点击事件*/
function onC(ths) {
    ths.innerHTML = '复制成功';
}
/*鼠标移出事件*/
function mOut(ths) {
    setTimeout(function () {
        ths.innerHTML = '复制';
    }, 15000);
}

$(function () {
    //marked插件的基本配置
    marked.setOptions({
        renderer: new marked.Renderer(),
        gfm: true,
        tables: true,
        breaks: false,
        pedantic: false,
        sanitize: false,
        smartLists: true,
        smartypants: false,
        highlight: function (code, lang) {
            //使用 highlight 插件解析文档中代码部分
            return hljs.highlightAuto(code, [lang]).value;
        }
    });

    document.body.innerHTML = marked(document.body.innerHTML);

    //渲染文档中代码部分
    hljs.initHighlighting();

    addCopyButton();
});
