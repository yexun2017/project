$(function(){
    var initShopUrl='/shop/shopcategorylist';
    var registryShopUrl='/shop/registershop';
    initShopInfo();
    function initShopInfo(){
        $.getJSON(initShopUrl,function(data) {
            if (data.success){
                var tempHtml = '';
                var tempAreaHtml = '';
               data.shopCategoryList.map(function (item, index) {
                   tempHtml+='<option data-id="'+ item.shopCategoryId +'">' + item.shopCategoryName + '</option>';
                });
                data.areaList.map(function(item, index) {
                    tempAreaHtml += '<option data-id="' + item.areaId + '">'
                        + item.areaName + '</option>';
                });
                $('#shopCategory').html(tempHtml);
                //$('#shop-shopCategory').attr('disabled','disabled');
                $('#area').html(tempAreaHtml);
                //$('#area').attr('data-id',shop.areaId);
            }
        });
    }
    $('#submit').click(function() {
        var shop = {};
        shop.shopName = $('#shopName').val();
        shop.shopCategory = {
            shopCategoryId : $('#shopCategory').find('option').not(function() {
                return !this.selected;
            }).data('id')
        };
        shop.area = {
            areaId : $('#area').find('option').not(function() {
                return !this.selected;
            }).data('id')
        };
        shop.shopAddr = $('#shopAddr').val();
        shop.phone = $('#shopPhone').val();
        var shopImg = $("#shopImg")[0].files[0];
        shop.shopDesc = $('#shopDesc').val();
        var formData = new FormData();
        formData.append('shopImg', shopImg);
        formData.append('shopStr', JSON.stringify(shop));
        var verifyCodeActual = $('#jCaptcha').val();
        if (!verifyCodeActual) {
            $.toast('请输入验证码！');
            return;
        }
        formData.append("verifyCodeActual", verifyCodeActual);
        $.ajax({
            url : registryShopUrl,
            type : 'POST',
            // contentType: "application/x-www-form-urlencoded; charset=utf-8",
            data : formData,
            contentType : false,
            processData : false,
            cache : false,
            success : function(data) {
                if (data.success) {
                    $.toast('提交成功！');
                } else {
                    $.toast('提交失败！');
                }
                $('#captchaImg').click();
            }
        });
    });
});