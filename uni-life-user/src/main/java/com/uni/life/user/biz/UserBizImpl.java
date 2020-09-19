//package com.uni.life.user.biz;
//
//import com.uni.life.user.api.UserBiz;
//import com.uni.service.sign.dto.SignRequestDto;
//import com.uni.service.sign.dto.SignResponseDto;
//import com.uni.service.sign.service.SignService;
//import org.springframework.beans.BeansException;
//import org.springframework.context.ApplicationContext;
//import org.springframework.context.ApplicationContextAware;
//import org.springframework.stereotype.Service;
//
///**
// * @Author lait.zhang@gmail.com
// * @Tel 15801818092
// * @Date 8/26/2020
// * @Description ${Description}
// */
//@Service
//public class UserBizImpl implements UserBiz, ApplicationContextAware {
//
//
//    private ApplicationContext applicationContext;
//    /**
//     * 根据参数判断使用那个渠道注册
//     */
//    @Override
//    public SignResponseDto signin(SignRequestDto signRequest) {
//        SignService signService = applicationContext.getBean(signRequest.getChanelType(),SignService.class);
//        SignResponseDto signResponseDto = signService.signin(signRequest);
//        return signResponseDto;
//    }
//
//    @Override
//    public void signout(String uid) {
//        SignService signService = null;
//        signService.singout();
//    }
//
//    @Override
//    public void login() {
//
//    }
//
//    @Override
//    public void updUserInfo() {
//
//    }
//
//    @Override
//    public void getUserInfo() {
//
//    }
//
//
//    @Override
//    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
//        this.applicationContext = applicationContext;
//    }
//}
