package com.wwx.myo2o.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.wwx.myo2o.common.ResponseCode;
import com.wwx.myo2o.common.ServerResponse;
import com.wwx.myo2o.entity.Area;
import com.wwx.myo2o.entity.PersonInfo;
import com.wwx.myo2o.entity.Shop;
import com.wwx.myo2o.entity.ShopCategory;
import com.wwx.myo2o.service.AreaService;
import com.wwx.myo2o.service.ShopCategoryService;
import com.wwx.myo2o.service.ShopService;
import com.wwx.myo2o.utils.CodeUtil;
import com.wwx.myo2o.utils.HttpServletRequestUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author: wangwx5
 * @Email: wangwx5@asiainfo.com
 * CreateDate: 2018/10/27  11:13
 **/
@RestController
@Slf4j
@RequestMapping("/shop")
public class ShopController {

    @Autowired
    private AreaService areaService;

    @Autowired
    private ShopService shopService;

    @Autowired
    private ShopCategoryService shopCategoryService;


    @Autowired
    private CommonsMultipartResolver multipartResolver;

    @RequestMapping(value = "/shopcategorylist",method = RequestMethod.GET)
    public Map<String ,Object> shopCategoryList(){
        HashMap<String,Object> returnMap=new HashMap();
        try {
            List<ShopCategory>  shopCategoryList=shopCategoryService.queryShopCategoryListInfo(new ShopCategory());
            List<Area> areaList=areaService.queryAllAreas();
            returnMap.put("success",true);
            returnMap.put("shopCategoryList",shopCategoryList);
            returnMap.put("areaList",areaList);
        } catch (Exception e) {
            returnMap.put("success",false);
            returnMap.put("errMsg",e.getMessage());
            e.printStackTrace();
        }
        return returnMap;
    }

    @RequestMapping(value = "/addshop",method = RequestMethod.PUT)
    public Map<String ,Object> addShop(@RequestBody Shop shop){
        HashMap<String,Object> returnMap=new HashMap();
        try {
            //shopService.save(shop);
            returnMap.put("success",true);
        } catch (Exception e) {
            returnMap.put("success",false);
            returnMap.put("errMsg",e.getMessage());
            e.printStackTrace();
        }
        return returnMap;
    }

    @RequestMapping(value = "/registershop",method = RequestMethod.POST)
    public Map<String ,Object> registerShop(HttpServletRequest request){
        HashMap<String,Object> returnMap=new HashMap();
        if(!CodeUtil.checkVerifyCode(request)){
            returnMap.put("success",false);
            returnMap.put("errMsg","验证码错误！");
            return returnMap;
        }
        String  shopStr = HttpServletRequestUtil.getString(request,"shopStr");
        ObjectMapper objectMapper=new ObjectMapper();
        Shop shop = null;
        try {
            shop=objectMapper.readValue(shopStr,Shop.class);
        } catch (Exception e) {
            returnMap.put("success",false);
            returnMap.put("errMsg",e.getMessage());
            return returnMap;
        }
        CommonsMultipartFile shopImg = null;
        multipartResolver.setServletContext(request.getSession().getServletContext());
        if (multipartResolver.isMultipart(request)) {
            MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) request;
            shopImg = (CommonsMultipartFile) multipartRequest.getFile("shopImg");
        } else {
            returnMap.put("success", false);
            returnMap.put("errMsg", "上传图片不能为空");
            return returnMap;
        }
        if (shop != null && shopImg != null) {
            try {
                //PersonInfo user = (PersonInfo) request.getSession().getAttribute("user");
                shop.setOwnerId(8L);
                ServerResponse serverResponse = shopService.save(shop, shopImg);
                if (serverResponse.getStatus() == ServerResponse.createBySuccess().getStatus()) {
                    returnMap.put("success", true);
                    // 若shop创建成功，则加入session中，作为权限使用
                    @SuppressWarnings("unchecked")
                    List<Shop> shopList = (List<Shop>) request.getSession().getAttribute("shopList");
                    if (shopList != null && shopList.size() > 0) {
                        shopList.add((Shop)serverResponse.getData());
                        request.getSession().setAttribute("shopList", shopList);
                    } else {
                        shopList = new ArrayList<Shop>();
                        shopList.add((Shop)serverResponse.getData());
                        request.getSession().setAttribute("shopList", shopList);
                    }
                } else {
                    returnMap.put("success", false);
                    returnMap.put("errMsg", serverResponse.getMsg());
                }
            } catch (RuntimeException e) {
                returnMap.put("success", false);
                returnMap.put("errMsg", e.toString());
                return returnMap;
            }

        } else {
            returnMap.put("success", false);
            returnMap.put("errMsg", "请输入店铺信息");
        }
        return returnMap;
    }
  /*  public Map<String,Object> selectByIds(){

    }*/
 }
