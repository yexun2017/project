
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title>商店信息</title>
    <meta name="viewport" content="initial-scale=1, maximum-scale=1">
    <link rel="shortcut icon" href="/favicon.ico">
    <meta name="apple-mobile-web-app-capable" content="yes">
    <meta name="apple-mobile-web-app-status-bar-style" content="black">
    <link rel="stylesheet" href="//g.alicdn.com/msui/sm/0.6.2/css/sm.min.css">
    <link rel="stylesheet" href="//g.alicdn.com/msui/sm/0.6.2/css/sm-extend.min.css">
</head>
<body>
<header class="bar bar-nav">
    <h1 class="title">商店信息</h1>
</header>
        <div class="content">
            <div class="list-block">
                <ul>

                    <li>
                        <div class="item-content">
                            <div class="item-media">
                                <i class="icon icon-form-name"></i>
                            </div>
                            <div class="item-inner">
                                <div class="item-title label">商店名称</div>
                                <div class="item-input">
                                    <input type="text" id="shopName" placeholder="商店名称">
                                </div>
                            </div>
                        </div>
                    </li>

                    <li>
                        <div class="item-content">
                            <div class="item-media">
                                <i class="icon icon-form-email"></i>
                            </div>
                            <div class="item-inner">
                                <div class="item-title label">商铺分类</div>
                                <div class="item-input">
                                    <select id="shopCategory">
                                    </select>
                                </div>
                            </div>
                        </div>
                    </li>
                    <li>
                        <div class="item-content">
                            <div class="item-media">
                                <i class="icon icon-form-email"></i>
                            </div>
                            <div class="item-inner">
                                <div class="item-title label">所属区域</div>
                                <div class="item-input">
                                    <select id="area">
                                    </select>
                                </div>
                            </div>
                        </div>
                    </li>

                    <li>
                        <div class="item-content">
                            <div class="item-media">
                                <i class="icon icon-form-email"></i>
                            </div>
                            <div class="item-inner">
                                <div class="item-title label">详细地址</div>
                                <div class="item-input">
                                    <input type="text" id="shopAddr" placeholder="详细地址">
                                </div>
                            </div>
                        </div>
                    </li>

                    <li>
                        <div class="item-content">
                            <div class="item-media">
                                <i class="icon icon-form-email"></i>
                            </div>
                            <div class="item-inner">
                                <div class="item-title label">联系电话</div>
                                <div class="item-input">
                                    <input type="text" id="shopPhone" placeholder="联系电话">
                                </div>
                            </div>
                        </div>
                    </li>

                    <li>
                        <div class="item-content">
                            <div class="item-media">
                                <i class="icon icon-form-email"></i>
                            </div>
                            <div class="item-inner">
                                <div class="item-title label">缩略图</div>
                                <div class="item-input">
                                    <input type="file" id="shopImg" >
                                </div>
                            </div>
                        </div>
                    </li>

                    <li class="align-top">
                        <div class="item-content">
                            <div class="item-media">
                                <i class="icon icon-form-email"></i>
                            </div>
                            <div class="item-inner">
                                <div class="item-title label">店铺简介</div>
                                <div class="item-input">
                                    <textarea id="shopDesc" placeholder="店铺简介"></textarea>
                                </div>
                            </div>
                        </div>
                    </li>
                    <li>
                        <div class="item-content">
                            <div class="item-media">
                                <i class="icon icon-form-email"></i>
                            </div>
                            <div class="item-inner">
                                <label for="j_captcha" class="item-title label">验证码</label> <input
                                    id="jCaptcha" name="jCaptcha" type="text" class="form-control in" placeholder="验证码" />
                                <div class="item-input">
                                    <img id="captchaImg" alt="点击更换" title="点击更换" onclick="changeVerifyCode(this)" src="http://localhost:8080/getKaptchaImage" />
                                </div>
                            </div>
                        </div>
                    </li>
                </ul>
            </div>
            <div class="content-block">
                <div class="row">
                    <div class="col-50"><a href="#" class="button button-big button-fill button-danger">返回</a></div>
                    <div class="col-50"><a href="#" class="button button-big button-fill button-success" id="submit">提交</a></div>
                </div>
            </div>
        </div>
    </div>

</div>
<script type='text/javascript' src='//g.alicdn.com/sj/lib/zepto/zepto.min.js' charset='utf-8'></script>
<script type='text/javascript' src='//g.alicdn.com/msui/sm/0.6.2/js/sm.min.js' charset='utf-8'></script>
<script type='text/javascript' src='//g.alicdn.com/msui/sm/0.6.2/js/sm-extend.min.js' charset='utf-8'></script>
<script type='text/javascript' src='js/shop/shopOper.js' charset='utf-8'></script>
<script type='text/javascript' src='js/common/common.js' charset='utf-8'></script>
</body>
</html>
