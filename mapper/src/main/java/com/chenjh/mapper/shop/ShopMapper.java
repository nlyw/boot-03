package com.chenjh.mapper.shop;

import com.chenjh.entity.shop.Shop;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

@Mapper
public interface ShopMapper {

    @Select(" <script>" +
            " select t_id shopID, t_name shopName," +
            " t_type shopType, t_tags shopTags, t_addr shopAddr," +
            " date_format(t_date, '%Y-%m-%d') shopDateStr" +
            " from t_shops" +
            " where 1 = 1" +
            " <if test='null != shopName and \"\" != shopName'>" +
            " and t_name like concat('%', #{shopName}, '%')" +
            " </if>" +
            " <if test='0 &lt; shopAddr'>" +
            " and t_addr = #{shopAddr}" +
            " </if>" +
            " </script>")
    List<Shop> selectShopList(Shop shop);

    @Select(" select t_id shopID, t_name shopName," +
            " t_type shopType, t_tags shopTags, t_addr shopAddr," +
            " date_format(t_date, '%Y-%m-%d') shopDateStr" +
            " from t_shops" +
            " where t_id = #{shopID}")
    Shop selectShopInfoByID(Shop shop);

    @Update(" update t_shops set" +
            " t_name = #{shopName}," +
            " t_type = #{shopType}," +
            " t_tags = #{shopTags}," +
            " t_addr = #{shopAddr}," +
            " t_date = str_to_date(#{shopDateStr}, '%Y-%m-%d')" +
            " where t_id = #{shopID}")
    void updateShopInfoByID(Shop shop);
}
