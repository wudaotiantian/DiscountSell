package androidas.com.discountsell.bean;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by xwb on 2016/7/15.
 */
public class BeadTitle {

    /**
     * error_code : 0
     * error_message : true
     * data : {"list":{"banner":{"app_subject_pic":""},"products":{"list":[{"show_mode":2,"num_iid":"528787966789","no_commission":"0","app_goods_mode":2,"bai_chuan_mode":1,"pro_url":"http://s.click.taobao.com/t?e=m%3D2%26s%3DfS%2BOFBd6IEYcQipKwQzePOeEDrYVVa64pRe%2F8jaAHci5VBFTL4hn2aBN6oxcHGEfahEP0ZrOLIr3i4vlPtZLRwpkcK8XwAwRIH0g3yL3n%2F3mgia1qkScUsLXaPfdtsFVB0QPsQzdQnovMNZ5vuy8%2BiGFCzYOOqAQ","id":"835275","spare_id":"835275","show_commission_cent":1,"commission_cent":404,"isrec":-1,"app_isrec":"-1","pic":"http://img.alicdn.com/imgextra/i2/TB28tpKoFXXXXcWXXXXXXXXXXXX_!!467426552.jpg_290x290.jpg","title":"卓诗尼波西米亚凉鞋","promotion_price":138,"price":369,"ispost":"1","icon_top_left":2,"site":"天猫","discount":"3.74","volume":"2920","app_coupon_site":"","pc_coupon_site":"","shop_name":"卓诗尼旗舰店"},{"show_mode":2,"num_iid":"531063975032","no_commission":"0","app_goods_mode":2,"bai_chuan_mode":1,"pro_url":"http://s.click.taobao.com/t?e=m%3D2%26s%3DKEsHxd%2FVklAcQipKwQzePOeEDrYVVa64pRe%2F8jaAHci5VBFTL4hn2UvKg5LNTBtJZW1Lr5j6Def3i4vlPtZLRwpkcK8XwAwRIH0g3yL3n%2F3mgia1qkScUsLXaPfdtsFVf6g7wPx5FSBnaPSPgmS9jyGFCzYOOqAQ","id":"808039","spare_id":"808039","show_commission_cent":1,"commission_cent":96,"isrec":-1,"app_isrec":"-1","pic":"http://img.alicdn.com/imgextra/i2/TB2biAjoXXXXXaAXpXXXXXXXXXX_!!467426552.jpg_290x290.jpg","title":"卓诗尼搭扣凉拖鞋","promotion_price":61,"price":269,"ispost":"1","icon_top_left":2,"site":"天猫","discount":"2.27","volume":"2241","app_coupon_site":"","pc_coupon_site":"","shop_name":"卓诗尼旗舰店"},{"show_mode":2,"num_iid":"527743086428","no_commission":"0","app_goods_mode":2,"bai_chuan_mode":1,"pro_url":"http://s.click.taobao.com/t?e=m%3D2%26s%3DWc%2BL42Cdn5ocQipKwQzePOeEDrYVVa64pRe%2F8jaAHci5VBFTL4hn2ejSwoQoEZRg%2Fl0%2B1yuzCtL3i4vlPtZLRwpkcK8XwAwRIH0g3yL3n%2F3mgia1qkScUsLXaPfdtsFVMz4ka31gNOgDu2Qy1I5r6iGFCzYOOqAQ","id":"835299","spare_id":"835299","show_commission_cent":1,"commission_cent":462,"isrec":-1,"app_isrec":"-1","pic":"http://img.alicdn.com/imgextra/i2/TB20o6IXFXXXXcIXpXXXXXXXXXX_!!467426552.jpg_290x290.jpg","title":"卓诗尼甜美坡跟鞋","promotion_price":158,"price":369,"ispost":"1","icon_top_left":2,"site":"天猫","discount":"4.28","volume":"2140","app_coupon_site":"","pc_coupon_site":"","shop_name":"卓诗尼旗舰店"},{"show_mode":2,"num_iid":"527961345109","no_commission":"0","app_goods_mode":2,"bai_chuan_mode":1,"pro_url":"http://s.click.taobao.com/t?e=m%3D2%26s%3DRHX%2FnHLc7T8cQipKwQzePOeEDrYVVa64pRe%2F8jaAHci5VBFTL4hn2cAvn1kAo%2F%2BdwSB8%2FImevID3i4vlPtZLRwpkcK8XwAwRIH0g3yL3n%2F3mgia1qkScUsLXaPfdtsFVnqC6vMzOZDbGjuzJMjPwqCGFCzYOOqAQ","id":"780187","spare_id":"780187","show_commission_cent":1,"commission_cent":415,"isrec":-1,"app_isrec":"-1","pic":"http://img.alicdn.com/imgextra/i2/TB2dlHrsXXXXXbmXXXXXXXXXXXX_!!467426552.jpg_290x290.jpg","title":"卓诗尼铆钉凉鞋","promotion_price":142,"price":369,"ispost":"1","icon_top_left":2,"site":"天猫","discount":"3.85","volume":"2014","app_coupon_site":"","pc_coupon_site":"","shop_name":"卓诗尼旗舰店"},{"show_mode":2,"num_iid":"528990912779","no_commission":"0","app_goods_mode":2,"bai_chuan_mode":1,"pro_url":"http://s.click.taobao.com/t?e=m%3D2%26s%3DG552Zbk%2FW4UcQipKwQzePOeEDrYVVa64pRe%2F8jaAHci5VBFTL4hn2ZWMHz8OYy3rUOZr0mLjusf3i4vlPtZLRwpkcK8XwAwRIH0g3yL3n%2F3mgia1qkScUsLXaPfdtsFVfQJUaSoCmzN4B%2Fu%2FUdxnVSGFCzYOOqAQ","id":"808041","spare_id":"808041","show_commission_cent":1,"commission_cent":249,"isrec":-1,"app_isrec":"-1","pic":"http://img.alicdn.com/imgextra/i2/TB2dcGcoFXXXXbUXXXXXXXXXXXX_!!467426552.jpg_290x290.jpg","title":"卓诗尼水钻凉鞋","promotion_price":158,"price":399,"ispost":"1","icon_top_left":2,"site":"天猫","discount":"3.96","volume":"1687","app_coupon_site":"","pc_coupon_site":"","shop_name":"卓诗尼旗舰店"},{"show_mode":2,"num_iid":"528477890525","no_commission":"0","app_goods_mode":2,"bai_chuan_mode":1,"pro_url":"http://s.click.taobao.com/t?e=m%3D2%26s%3DZC3CIkLauNUcQipKwQzePOeEDrYVVa64pRe%2F8jaAHci5VBFTL4hn2XWGauAHgBJ%2FghoTQriFyXz3i4vlPtZLRwpkcK8XwAwRIH0g3yL3n%2F3mgia1qkScUsLXaPfdtsFVJxTek084aJOhEGv1rcqX9CGFCzYOOqAQ","id":"835346","spare_id":"835346","show_commission_cent":1,"commission_cent":415,"isrec":-1,"app_isrec":"-1","pic":"http://img.alicdn.com/imgextra/i2/TB2ysDOoFXXXXc4XXXXXXXXXXXX_!!467426552.jpg_290x290.jpg","title":"卓诗尼时装凉鞋","promotion_price":142,"price":439,"ispost":"1","icon_top_left":2,"site":"天猫","discount":"3.23","volume":"1647","app_coupon_site":"","pc_coupon_site":"","shop_name":"卓诗尼旗舰店"},{"show_mode":2,"num_iid":"527745314550","no_commission":"0","app_goods_mode":2,"bai_chuan_mode":1,"pro_url":"http://s.click.taobao.com/t?e=m%3D2%26s%3DlOwp4geB2bkcQipKwQzePOeEDrYVVa64pRe%2F8jaAHci5VBFTL4hn2SIj15WvJNinlg6AtVBcXjz3i4vlPtZLRwpkcK8XwAwRIH0g3yL3n%2F3mgia1qkScUsLXaPfdtsFVlncNffBh1kmQHxHUdDI1TiGFCzYOOqAQ","id":"747694","spare_id":"747694","show_commission_cent":1,"commission_cent":415,"isrec":-1,"app_isrec":"-1","pic":"http://img.alicdn.com/imgextra/i2/TB2b8FLoVXXXXXWXpXXXXXXXXXX_!!467426552.jpg_290x290.jpg","title":"卓诗尼方跟凉鞋","promotion_price":142,"price":299,"ispost":"1","icon_top_left":2,"site":"天猫","discount":"4.75","volume":"1253","app_coupon_site":"","pc_coupon_site":"","shop_name":"卓诗尼旗舰店"},{"show_mode":2,"num_iid":"527973048717","no_commission":"0","app_goods_mode":2,"bai_chuan_mode":1,"pro_url":"http://s.click.taobao.com/t?e=m%3D2%26s%3DHM1Kr84jD24cQipKwQzePOeEDrYVVa64pRe%2F8jaAHci5VBFTL4hn2ZNQiFZK%2F%2B27kfkm8XrrgBv3i4vlPtZLRwpkcK8XwAwRIH0g3yL3n%2F3mgia1qkScUsLXaPfdtsFV%2BexfbkGeDdp5tJGAafyEViGFCzYOOqAQ","id":"747702","spare_id":"747702","show_commission_cent":1,"commission_cent":404,"isrec":-1,"app_isrec":"-1","pic":"http://img.alicdn.com/imgextra/i2/TB2Q0xWoVXXXXcbXXXXXXXXXXXX_!!467426552.jpg_290x290.jpg","title":"卓诗尼印花坡跟凉鞋","promotion_price":138,"price":299,"ispost":"1","icon_top_left":2,"site":"天猫","discount":"4.62","volume":"897","app_coupon_site":"","pc_coupon_site":"","shop_name":"卓诗尼旗舰店"},{"show_mode":2,"num_iid":"528134474336","no_commission":"0","app_goods_mode":2,"bai_chuan_mode":1,"pro_url":"http://s.click.taobao.com/t?e=m%3D2%26s%3DqhPmYwka2YgcQipKwQzePOeEDrYVVa64pRe%2F8jaAHci5VBFTL4hn2QPjp2pxppN8c4zWPc6e8233i4vlPtZLRwpkcK8XwAwRIH0g3yL3n%2F3mgia1qkScUsLXaPfdtsFVcvuGOWROa2tiIx7eT6dmlSGFCzYOOqAQ","id":"835274","spare_id":"835274","show_commission_cent":1,"commission_cent":217,"isrec":-1,"app_isrec":"-1","pic":"http://img.alicdn.com/imgextra/i2/TB2eDpToFXXXXcdXpXXXXXXXXXX_!!467426552.jpg_290x290.jpg","title":"卓诗尼一字搭扣凉鞋","promotion_price":138,"price":369,"ispost":"1","icon_top_left":2,"site":"天猫","discount":"3.74","volume":"631","app_coupon_site":"","pc_coupon_site":"","shop_name":"卓诗尼旗舰店"},{"show_mode":2,"num_iid":"530607793242","no_commission":"0","app_goods_mode":2,"bai_chuan_mode":1,"pro_url":"http://s.click.taobao.com/t?e=m%3D2%26s%3DOue31XV8Y90cQipKwQzePOeEDrYVVa64pRe%2F8jaAHci5VBFTL4hn2YuaQzSDfXqorumJQoe%2FxcP3i4vlPtZLRwpkcK8XwAwRIH0g3yL3n%2F3mgia1qkScUsLXaPfdtsFVHFwFeHKUwMguzilrVAMqgyGFCzYOOqAQ","id":"835351","spare_id":"835351","show_commission_cent":1,"commission_cent":217,"isrec":-1,"app_isrec":"-1","pic":"http://img.alicdn.com/imgextra/i2/TB21JBcpFXXXXaIXFXXXXXXXXXX_!!467426552.jpg_290x290.jpg","title":"卓诗尼民族风凉鞋","promotion_price":138,"price":299,"ispost":"1","icon_top_left":2,"site":"天猫","discount":"4.62","volume":"621","app_coupon_site":"","pc_coupon_site":"","shop_name":"卓诗尼旗舰店"}]}}}
     */

    private int error_code;
    private String error_message;
    /**
     * list : {"banner":{"app_subject_pic":""},"products":{"list":[{"show_mode":2,"num_iid":"528787966789","no_commission":"0","app_goods_mode":2,"bai_chuan_mode":1,"pro_url":"http://s.click.taobao.com/t?e=m%3D2%26s%3DfS%2BOFBd6IEYcQipKwQzePOeEDrYVVa64pRe%2F8jaAHci5VBFTL4hn2aBN6oxcHGEfahEP0ZrOLIr3i4vlPtZLRwpkcK8XwAwRIH0g3yL3n%2F3mgia1qkScUsLXaPfdtsFVB0QPsQzdQnovMNZ5vuy8%2BiGFCzYOOqAQ","id":"835275","spare_id":"835275","show_commission_cent":1,"commission_cent":404,"isrec":-1,"app_isrec":"-1","pic":"http://img.alicdn.com/imgextra/i2/TB28tpKoFXXXXcWXXXXXXXXXXXX_!!467426552.jpg_290x290.jpg","title":"卓诗尼波西米亚凉鞋","promotion_price":138,"price":369,"ispost":"1","icon_top_left":2,"site":"天猫","discount":"3.74","volume":"2920","app_coupon_site":"","pc_coupon_site":"","shop_name":"卓诗尼旗舰店"},{"show_mode":2,"num_iid":"531063975032","no_commission":"0","app_goods_mode":2,"bai_chuan_mode":1,"pro_url":"http://s.click.taobao.com/t?e=m%3D2%26s%3DKEsHxd%2FVklAcQipKwQzePOeEDrYVVa64pRe%2F8jaAHci5VBFTL4hn2UvKg5LNTBtJZW1Lr5j6Def3i4vlPtZLRwpkcK8XwAwRIH0g3yL3n%2F3mgia1qkScUsLXaPfdtsFVf6g7wPx5FSBnaPSPgmS9jyGFCzYOOqAQ","id":"808039","spare_id":"808039","show_commission_cent":1,"commission_cent":96,"isrec":-1,"app_isrec":"-1","pic":"http://img.alicdn.com/imgextra/i2/TB2biAjoXXXXXaAXpXXXXXXXXXX_!!467426552.jpg_290x290.jpg","title":"卓诗尼搭扣凉拖鞋","promotion_price":61,"price":269,"ispost":"1","icon_top_left":2,"site":"天猫","discount":"2.27","volume":"2241","app_coupon_site":"","pc_coupon_site":"","shop_name":"卓诗尼旗舰店"},{"show_mode":2,"num_iid":"527743086428","no_commission":"0","app_goods_mode":2,"bai_chuan_mode":1,"pro_url":"http://s.click.taobao.com/t?e=m%3D2%26s%3DWc%2BL42Cdn5ocQipKwQzePOeEDrYVVa64pRe%2F8jaAHci5VBFTL4hn2ejSwoQoEZRg%2Fl0%2B1yuzCtL3i4vlPtZLRwpkcK8XwAwRIH0g3yL3n%2F3mgia1qkScUsLXaPfdtsFVMz4ka31gNOgDu2Qy1I5r6iGFCzYOOqAQ","id":"835299","spare_id":"835299","show_commission_cent":1,"commission_cent":462,"isrec":-1,"app_isrec":"-1","pic":"http://img.alicdn.com/imgextra/i2/TB20o6IXFXXXXcIXpXXXXXXXXXX_!!467426552.jpg_290x290.jpg","title":"卓诗尼甜美坡跟鞋","promotion_price":158,"price":369,"ispost":"1","icon_top_left":2,"site":"天猫","discount":"4.28","volume":"2140","app_coupon_site":"","pc_coupon_site":"","shop_name":"卓诗尼旗舰店"},{"show_mode":2,"num_iid":"527961345109","no_commission":"0","app_goods_mode":2,"bai_chuan_mode":1,"pro_url":"http://s.click.taobao.com/t?e=m%3D2%26s%3DRHX%2FnHLc7T8cQipKwQzePOeEDrYVVa64pRe%2F8jaAHci5VBFTL4hn2cAvn1kAo%2F%2BdwSB8%2FImevID3i4vlPtZLRwpkcK8XwAwRIH0g3yL3n%2F3mgia1qkScUsLXaPfdtsFVnqC6vMzOZDbGjuzJMjPwqCGFCzYOOqAQ","id":"780187","spare_id":"780187","show_commission_cent":1,"commission_cent":415,"isrec":-1,"app_isrec":"-1","pic":"http://img.alicdn.com/imgextra/i2/TB2dlHrsXXXXXbmXXXXXXXXXXXX_!!467426552.jpg_290x290.jpg","title":"卓诗尼铆钉凉鞋","promotion_price":142,"price":369,"ispost":"1","icon_top_left":2,"site":"天猫","discount":"3.85","volume":"2014","app_coupon_site":"","pc_coupon_site":"","shop_name":"卓诗尼旗舰店"},{"show_mode":2,"num_iid":"528990912779","no_commission":"0","app_goods_mode":2,"bai_chuan_mode":1,"pro_url":"http://s.click.taobao.com/t?e=m%3D2%26s%3DG552Zbk%2FW4UcQipKwQzePOeEDrYVVa64pRe%2F8jaAHci5VBFTL4hn2ZWMHz8OYy3rUOZr0mLjusf3i4vlPtZLRwpkcK8XwAwRIH0g3yL3n%2F3mgia1qkScUsLXaPfdtsFVfQJUaSoCmzN4B%2Fu%2FUdxnVSGFCzYOOqAQ","id":"808041","spare_id":"808041","show_commission_cent":1,"commission_cent":249,"isrec":-1,"app_isrec":"-1","pic":"http://img.alicdn.com/imgextra/i2/TB2dcGcoFXXXXbUXXXXXXXXXXXX_!!467426552.jpg_290x290.jpg","title":"卓诗尼水钻凉鞋","promotion_price":158,"price":399,"ispost":"1","icon_top_left":2,"site":"天猫","discount":"3.96","volume":"1687","app_coupon_site":"","pc_coupon_site":"","shop_name":"卓诗尼旗舰店"},{"show_mode":2,"num_iid":"528477890525","no_commission":"0","app_goods_mode":2,"bai_chuan_mode":1,"pro_url":"http://s.click.taobao.com/t?e=m%3D2%26s%3DZC3CIkLauNUcQipKwQzePOeEDrYVVa64pRe%2F8jaAHci5VBFTL4hn2XWGauAHgBJ%2FghoTQriFyXz3i4vlPtZLRwpkcK8XwAwRIH0g3yL3n%2F3mgia1qkScUsLXaPfdtsFVJxTek084aJOhEGv1rcqX9CGFCzYOOqAQ","id":"835346","spare_id":"835346","show_commission_cent":1,"commission_cent":415,"isrec":-1,"app_isrec":"-1","pic":"http://img.alicdn.com/imgextra/i2/TB2ysDOoFXXXXc4XXXXXXXXXXXX_!!467426552.jpg_290x290.jpg","title":"卓诗尼时装凉鞋","promotion_price":142,"price":439,"ispost":"1","icon_top_left":2,"site":"天猫","discount":"3.23","volume":"1647","app_coupon_site":"","pc_coupon_site":"","shop_name":"卓诗尼旗舰店"},{"show_mode":2,"num_iid":"527745314550","no_commission":"0","app_goods_mode":2,"bai_chuan_mode":1,"pro_url":"http://s.click.taobao.com/t?e=m%3D2%26s%3DlOwp4geB2bkcQipKwQzePOeEDrYVVa64pRe%2F8jaAHci5VBFTL4hn2SIj15WvJNinlg6AtVBcXjz3i4vlPtZLRwpkcK8XwAwRIH0g3yL3n%2F3mgia1qkScUsLXaPfdtsFVlncNffBh1kmQHxHUdDI1TiGFCzYOOqAQ","id":"747694","spare_id":"747694","show_commission_cent":1,"commission_cent":415,"isrec":-1,"app_isrec":"-1","pic":"http://img.alicdn.com/imgextra/i2/TB2b8FLoVXXXXXWXpXXXXXXXXXX_!!467426552.jpg_290x290.jpg","title":"卓诗尼方跟凉鞋","promotion_price":142,"price":299,"ispost":"1","icon_top_left":2,"site":"天猫","discount":"4.75","volume":"1253","app_coupon_site":"","pc_coupon_site":"","shop_name":"卓诗尼旗舰店"},{"show_mode":2,"num_iid":"527973048717","no_commission":"0","app_goods_mode":2,"bai_chuan_mode":1,"pro_url":"http://s.click.taobao.com/t?e=m%3D2%26s%3DHM1Kr84jD24cQipKwQzePOeEDrYVVa64pRe%2F8jaAHci5VBFTL4hn2ZNQiFZK%2F%2B27kfkm8XrrgBv3i4vlPtZLRwpkcK8XwAwRIH0g3yL3n%2F3mgia1qkScUsLXaPfdtsFV%2BexfbkGeDdp5tJGAafyEViGFCzYOOqAQ","id":"747702","spare_id":"747702","show_commission_cent":1,"commission_cent":404,"isrec":-1,"app_isrec":"-1","pic":"http://img.alicdn.com/imgextra/i2/TB2Q0xWoVXXXXcbXXXXXXXXXXXX_!!467426552.jpg_290x290.jpg","title":"卓诗尼印花坡跟凉鞋","promotion_price":138,"price":299,"ispost":"1","icon_top_left":2,"site":"天猫","discount":"4.62","volume":"897","app_coupon_site":"","pc_coupon_site":"","shop_name":"卓诗尼旗舰店"},{"show_mode":2,"num_iid":"528134474336","no_commission":"0","app_goods_mode":2,"bai_chuan_mode":1,"pro_url":"http://s.click.taobao.com/t?e=m%3D2%26s%3DqhPmYwka2YgcQipKwQzePOeEDrYVVa64pRe%2F8jaAHci5VBFTL4hn2QPjp2pxppN8c4zWPc6e8233i4vlPtZLRwpkcK8XwAwRIH0g3yL3n%2F3mgia1qkScUsLXaPfdtsFVcvuGOWROa2tiIx7eT6dmlSGFCzYOOqAQ","id":"835274","spare_id":"835274","show_commission_cent":1,"commission_cent":217,"isrec":-1,"app_isrec":"-1","pic":"http://img.alicdn.com/imgextra/i2/TB2eDpToFXXXXcdXpXXXXXXXXXX_!!467426552.jpg_290x290.jpg","title":"卓诗尼一字搭扣凉鞋","promotion_price":138,"price":369,"ispost":"1","icon_top_left":2,"site":"天猫","discount":"3.74","volume":"631","app_coupon_site":"","pc_coupon_site":"","shop_name":"卓诗尼旗舰店"},{"show_mode":2,"num_iid":"530607793242","no_commission":"0","app_goods_mode":2,"bai_chuan_mode":1,"pro_url":"http://s.click.taobao.com/t?e=m%3D2%26s%3DOue31XV8Y90cQipKwQzePOeEDrYVVa64pRe%2F8jaAHci5VBFTL4hn2YuaQzSDfXqorumJQoe%2FxcP3i4vlPtZLRwpkcK8XwAwRIH0g3yL3n%2F3mgia1qkScUsLXaPfdtsFVHFwFeHKUwMguzilrVAMqgyGFCzYOOqAQ","id":"835351","spare_id":"835351","show_commission_cent":1,"commission_cent":217,"isrec":-1,"app_isrec":"-1","pic":"http://img.alicdn.com/imgextra/i2/TB21JBcpFXXXXaIXFXXXXXXXXXX_!!467426552.jpg_290x290.jpg","title":"卓诗尼民族风凉鞋","promotion_price":138,"price":299,"ispost":"1","icon_top_left":2,"site":"天猫","discount":"4.62","volume":"621","app_coupon_site":"","pc_coupon_site":"","shop_name":"卓诗尼旗舰店"}]}}
     */

    private DataBean data;

    public int getError_code() {
        return error_code;
    }

    public void setError_code(int error_code) {
        this.error_code = error_code;
    }

    public String getError_message() {
        return error_message;
    }

    public void setError_message(String error_message) {
        this.error_message = error_message;
    }

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    public static class DataBean {
        /**
         * banner : {"app_subject_pic":""}
         * products : {"list":[{"show_mode":2,"num_iid":"528787966789","no_commission":"0","app_goods_mode":2,"bai_chuan_mode":1,"pro_url":"http://s.click.taobao.com/t?e=m%3D2%26s%3DfS%2BOFBd6IEYcQipKwQzePOeEDrYVVa64pRe%2F8jaAHci5VBFTL4hn2aBN6oxcHGEfahEP0ZrOLIr3i4vlPtZLRwpkcK8XwAwRIH0g3yL3n%2F3mgia1qkScUsLXaPfdtsFVB0QPsQzdQnovMNZ5vuy8%2BiGFCzYOOqAQ","id":"835275","spare_id":"835275","show_commission_cent":1,"commission_cent":404,"isrec":-1,"app_isrec":"-1","pic":"http://img.alicdn.com/imgextra/i2/TB28tpKoFXXXXcWXXXXXXXXXXXX_!!467426552.jpg_290x290.jpg","title":"卓诗尼波西米亚凉鞋","promotion_price":138,"price":369,"ispost":"1","icon_top_left":2,"site":"天猫","discount":"3.74","volume":"2920","app_coupon_site":"","pc_coupon_site":"","shop_name":"卓诗尼旗舰店"},{"show_mode":2,"num_iid":"531063975032","no_commission":"0","app_goods_mode":2,"bai_chuan_mode":1,"pro_url":"http://s.click.taobao.com/t?e=m%3D2%26s%3DKEsHxd%2FVklAcQipKwQzePOeEDrYVVa64pRe%2F8jaAHci5VBFTL4hn2UvKg5LNTBtJZW1Lr5j6Def3i4vlPtZLRwpkcK8XwAwRIH0g3yL3n%2F3mgia1qkScUsLXaPfdtsFVf6g7wPx5FSBnaPSPgmS9jyGFCzYOOqAQ","id":"808039","spare_id":"808039","show_commission_cent":1,"commission_cent":96,"isrec":-1,"app_isrec":"-1","pic":"http://img.alicdn.com/imgextra/i2/TB2biAjoXXXXXaAXpXXXXXXXXXX_!!467426552.jpg_290x290.jpg","title":"卓诗尼搭扣凉拖鞋","promotion_price":61,"price":269,"ispost":"1","icon_top_left":2,"site":"天猫","discount":"2.27","volume":"2241","app_coupon_site":"","pc_coupon_site":"","shop_name":"卓诗尼旗舰店"},{"show_mode":2,"num_iid":"527743086428","no_commission":"0","app_goods_mode":2,"bai_chuan_mode":1,"pro_url":"http://s.click.taobao.com/t?e=m%3D2%26s%3DWc%2BL42Cdn5ocQipKwQzePOeEDrYVVa64pRe%2F8jaAHci5VBFTL4hn2ejSwoQoEZRg%2Fl0%2B1yuzCtL3i4vlPtZLRwpkcK8XwAwRIH0g3yL3n%2F3mgia1qkScUsLXaPfdtsFVMz4ka31gNOgDu2Qy1I5r6iGFCzYOOqAQ","id":"835299","spare_id":"835299","show_commission_cent":1,"commission_cent":462,"isrec":-1,"app_isrec":"-1","pic":"http://img.alicdn.com/imgextra/i2/TB20o6IXFXXXXcIXpXXXXXXXXXX_!!467426552.jpg_290x290.jpg","title":"卓诗尼甜美坡跟鞋","promotion_price":158,"price":369,"ispost":"1","icon_top_left":2,"site":"天猫","discount":"4.28","volume":"2140","app_coupon_site":"","pc_coupon_site":"","shop_name":"卓诗尼旗舰店"},{"show_mode":2,"num_iid":"527961345109","no_commission":"0","app_goods_mode":2,"bai_chuan_mode":1,"pro_url":"http://s.click.taobao.com/t?e=m%3D2%26s%3DRHX%2FnHLc7T8cQipKwQzePOeEDrYVVa64pRe%2F8jaAHci5VBFTL4hn2cAvn1kAo%2F%2BdwSB8%2FImevID3i4vlPtZLRwpkcK8XwAwRIH0g3yL3n%2F3mgia1qkScUsLXaPfdtsFVnqC6vMzOZDbGjuzJMjPwqCGFCzYOOqAQ","id":"780187","spare_id":"780187","show_commission_cent":1,"commission_cent":415,"isrec":-1,"app_isrec":"-1","pic":"http://img.alicdn.com/imgextra/i2/TB2dlHrsXXXXXbmXXXXXXXXXXXX_!!467426552.jpg_290x290.jpg","title":"卓诗尼铆钉凉鞋","promotion_price":142,"price":369,"ispost":"1","icon_top_left":2,"site":"天猫","discount":"3.85","volume":"2014","app_coupon_site":"","pc_coupon_site":"","shop_name":"卓诗尼旗舰店"},{"show_mode":2,"num_iid":"528990912779","no_commission":"0","app_goods_mode":2,"bai_chuan_mode":1,"pro_url":"http://s.click.taobao.com/t?e=m%3D2%26s%3DG552Zbk%2FW4UcQipKwQzePOeEDrYVVa64pRe%2F8jaAHci5VBFTL4hn2ZWMHz8OYy3rUOZr0mLjusf3i4vlPtZLRwpkcK8XwAwRIH0g3yL3n%2F3mgia1qkScUsLXaPfdtsFVfQJUaSoCmzN4B%2Fu%2FUdxnVSGFCzYOOqAQ","id":"808041","spare_id":"808041","show_commission_cent":1,"commission_cent":249,"isrec":-1,"app_isrec":"-1","pic":"http://img.alicdn.com/imgextra/i2/TB2dcGcoFXXXXbUXXXXXXXXXXXX_!!467426552.jpg_290x290.jpg","title":"卓诗尼水钻凉鞋","promotion_price":158,"price":399,"ispost":"1","icon_top_left":2,"site":"天猫","discount":"3.96","volume":"1687","app_coupon_site":"","pc_coupon_site":"","shop_name":"卓诗尼旗舰店"},{"show_mode":2,"num_iid":"528477890525","no_commission":"0","app_goods_mode":2,"bai_chuan_mode":1,"pro_url":"http://s.click.taobao.com/t?e=m%3D2%26s%3DZC3CIkLauNUcQipKwQzePOeEDrYVVa64pRe%2F8jaAHci5VBFTL4hn2XWGauAHgBJ%2FghoTQriFyXz3i4vlPtZLRwpkcK8XwAwRIH0g3yL3n%2F3mgia1qkScUsLXaPfdtsFVJxTek084aJOhEGv1rcqX9CGFCzYOOqAQ","id":"835346","spare_id":"835346","show_commission_cent":1,"commission_cent":415,"isrec":-1,"app_isrec":"-1","pic":"http://img.alicdn.com/imgextra/i2/TB2ysDOoFXXXXc4XXXXXXXXXXXX_!!467426552.jpg_290x290.jpg","title":"卓诗尼时装凉鞋","promotion_price":142,"price":439,"ispost":"1","icon_top_left":2,"site":"天猫","discount":"3.23","volume":"1647","app_coupon_site":"","pc_coupon_site":"","shop_name":"卓诗尼旗舰店"},{"show_mode":2,"num_iid":"527745314550","no_commission":"0","app_goods_mode":2,"bai_chuan_mode":1,"pro_url":"http://s.click.taobao.com/t?e=m%3D2%26s%3DlOwp4geB2bkcQipKwQzePOeEDrYVVa64pRe%2F8jaAHci5VBFTL4hn2SIj15WvJNinlg6AtVBcXjz3i4vlPtZLRwpkcK8XwAwRIH0g3yL3n%2F3mgia1qkScUsLXaPfdtsFVlncNffBh1kmQHxHUdDI1TiGFCzYOOqAQ","id":"747694","spare_id":"747694","show_commission_cent":1,"commission_cent":415,"isrec":-1,"app_isrec":"-1","pic":"http://img.alicdn.com/imgextra/i2/TB2b8FLoVXXXXXWXpXXXXXXXXXX_!!467426552.jpg_290x290.jpg","title":"卓诗尼方跟凉鞋","promotion_price":142,"price":299,"ispost":"1","icon_top_left":2,"site":"天猫","discount":"4.75","volume":"1253","app_coupon_site":"","pc_coupon_site":"","shop_name":"卓诗尼旗舰店"},{"show_mode":2,"num_iid":"527973048717","no_commission":"0","app_goods_mode":2,"bai_chuan_mode":1,"pro_url":"http://s.click.taobao.com/t?e=m%3D2%26s%3DHM1Kr84jD24cQipKwQzePOeEDrYVVa64pRe%2F8jaAHci5VBFTL4hn2ZNQiFZK%2F%2B27kfkm8XrrgBv3i4vlPtZLRwpkcK8XwAwRIH0g3yL3n%2F3mgia1qkScUsLXaPfdtsFV%2BexfbkGeDdp5tJGAafyEViGFCzYOOqAQ","id":"747702","spare_id":"747702","show_commission_cent":1,"commission_cent":404,"isrec":-1,"app_isrec":"-1","pic":"http://img.alicdn.com/imgextra/i2/TB2Q0xWoVXXXXcbXXXXXXXXXXXX_!!467426552.jpg_290x290.jpg","title":"卓诗尼印花坡跟凉鞋","promotion_price":138,"price":299,"ispost":"1","icon_top_left":2,"site":"天猫","discount":"4.62","volume":"897","app_coupon_site":"","pc_coupon_site":"","shop_name":"卓诗尼旗舰店"},{"show_mode":2,"num_iid":"528134474336","no_commission":"0","app_goods_mode":2,"bai_chuan_mode":1,"pro_url":"http://s.click.taobao.com/t?e=m%3D2%26s%3DqhPmYwka2YgcQipKwQzePOeEDrYVVa64pRe%2F8jaAHci5VBFTL4hn2QPjp2pxppN8c4zWPc6e8233i4vlPtZLRwpkcK8XwAwRIH0g3yL3n%2F3mgia1qkScUsLXaPfdtsFVcvuGOWROa2tiIx7eT6dmlSGFCzYOOqAQ","id":"835274","spare_id":"835274","show_commission_cent":1,"commission_cent":217,"isrec":-1,"app_isrec":"-1","pic":"http://img.alicdn.com/imgextra/i2/TB2eDpToFXXXXcdXpXXXXXXXXXX_!!467426552.jpg_290x290.jpg","title":"卓诗尼一字搭扣凉鞋","promotion_price":138,"price":369,"ispost":"1","icon_top_left":2,"site":"天猫","discount":"3.74","volume":"631","app_coupon_site":"","pc_coupon_site":"","shop_name":"卓诗尼旗舰店"},{"show_mode":2,"num_iid":"530607793242","no_commission":"0","app_goods_mode":2,"bai_chuan_mode":1,"pro_url":"http://s.click.taobao.com/t?e=m%3D2%26s%3DOue31XV8Y90cQipKwQzePOeEDrYVVa64pRe%2F8jaAHci5VBFTL4hn2YuaQzSDfXqorumJQoe%2FxcP3i4vlPtZLRwpkcK8XwAwRIH0g3yL3n%2F3mgia1qkScUsLXaPfdtsFVHFwFeHKUwMguzilrVAMqgyGFCzYOOqAQ","id":"835351","spare_id":"835351","show_commission_cent":1,"commission_cent":217,"isrec":-1,"app_isrec":"-1","pic":"http://img.alicdn.com/imgextra/i2/TB21JBcpFXXXXaIXFXXXXXXXXXX_!!467426552.jpg_290x290.jpg","title":"卓诗尼民族风凉鞋","promotion_price":138,"price":299,"ispost":"1","icon_top_left":2,"site":"天猫","discount":"4.62","volume":"621","app_coupon_site":"","pc_coupon_site":"","shop_name":"卓诗尼旗舰店"}]}
         */

        @SerializedName("list")
        private ListBeanV listV;

        public ListBeanV getListV() {
            return listV;
        }

        public void setListV(ListBeanV listV) {
            this.listV = listV;
        }

        public static class ListBeanV {
            /**
             * app_subject_pic :
             */

            private BannerBean banner;
            private ProductsBean products;

            public BannerBean getBanner() {
                return banner;
            }

            public void setBanner(BannerBean banner) {
                this.banner = banner;
            }

            public ProductsBean getProducts() {
                return products;
            }

            public void setProducts(ProductsBean products) {
                this.products = products;
            }

            public static class BannerBean {
                private String app_subject_pic;

                public String getApp_subject_pic() {
                    return app_subject_pic;
                }

                public void setApp_subject_pic(String app_subject_pic) {
                    this.app_subject_pic = app_subject_pic;
                }
            }

            public static class ProductsBean {
                /**
                 * show_mode : 2
                 * num_iid : 528787966789
                 * no_commission : 0
                 * app_goods_mode : 2
                 * bai_chuan_mode : 1
                 * pro_url : http://s.click.taobao.com/t?e=m%3D2%26s%3DfS%2BOFBd6IEYcQipKwQzePOeEDrYVVa64pRe%2F8jaAHci5VBFTL4hn2aBN6oxcHGEfahEP0ZrOLIr3i4vlPtZLRwpkcK8XwAwRIH0g3yL3n%2F3mgia1qkScUsLXaPfdtsFVB0QPsQzdQnovMNZ5vuy8%2BiGFCzYOOqAQ
                 * id : 835275
                 * spare_id : 835275
                 * show_commission_cent : 1
                 * commission_cent : 404
                 * isrec : -1
                 * app_isrec : -1
                 * pic : http://img.alicdn.com/imgextra/i2/TB28tpKoFXXXXcWXXXXXXXXXXXX_!!467426552.jpg_290x290.jpg
                 * title : 卓诗尼波西米亚凉鞋
                 * promotion_price : 138
                 * price : 369
                 * ispost : 1
                 * icon_top_left : 2
                 * site : 天猫
                 * discount : 3.74
                 * volume : 2920
                 * app_coupon_site :
                 * pc_coupon_site :
                 * shop_name : 卓诗尼旗舰店
                 */

                private List<ListBean> list;

                public List<ListBean> getList() {
                    return list;
                }

                public void setList(List<ListBean> list) {
                    this.list = list;
                }

                public static class ListBean {
                    private int show_mode;
                    private String num_iid;
                    private String no_commission;
                    private int app_goods_mode;
                    private int bai_chuan_mode;
                    private String pro_url;
                    private String id;
                    private String spare_id;
                    private int show_commission_cent;
                    private int commission_cent;
                    private int isrec;
                    private String app_isrec;
                    private String pic;
                    private String title;
                    private double promotion_price;
                    private double price;
                    private String ispost;
                    private int icon_top_left;
                    private String site;
                    private String discount;
                    private String volume;
                    private String app_coupon_site;
                    private String pc_coupon_site;
                    private String shop_name;

                    public int getShow_mode() {
                        return show_mode;
                    }

                    public void setShow_mode(int show_mode) {
                        this.show_mode = show_mode;
                    }

                    public String getNum_iid() {
                        return num_iid;
                    }

                    public void setNum_iid(String num_iid) {
                        this.num_iid = num_iid;
                    }

                    public String getNo_commission() {
                        return no_commission;
                    }

                    public void setNo_commission(String no_commission) {
                        this.no_commission = no_commission;
                    }

                    public int getApp_goods_mode() {
                        return app_goods_mode;
                    }

                    public void setApp_goods_mode(int app_goods_mode) {
                        this.app_goods_mode = app_goods_mode;
                    }

                    public int getBai_chuan_mode() {
                        return bai_chuan_mode;
                    }

                    public void setBai_chuan_mode(int bai_chuan_mode) {
                        this.bai_chuan_mode = bai_chuan_mode;
                    }

                    public String getPro_url() {
                        return pro_url;
                    }

                    public void setPro_url(String pro_url) {
                        this.pro_url = pro_url;
                    }

                    public String getId() {
                        return id;
                    }

                    public void setId(String id) {
                        this.id = id;
                    }

                    public String getSpare_id() {
                        return spare_id;
                    }

                    public void setSpare_id(String spare_id) {
                        this.spare_id = spare_id;
                    }

                    public int getShow_commission_cent() {
                        return show_commission_cent;
                    }

                    public void setShow_commission_cent(int show_commission_cent) {
                        this.show_commission_cent = show_commission_cent;
                    }

                    public int getCommission_cent() {
                        return commission_cent;
                    }

                    public void setCommission_cent(int commission_cent) {
                        this.commission_cent = commission_cent;
                    }

                    public int getIsrec() {
                        return isrec;
                    }

                    public void setIsrec(int isrec) {
                        this.isrec = isrec;
                    }

                    public String getApp_isrec() {
                        return app_isrec;
                    }

                    public void setApp_isrec(String app_isrec) {
                        this.app_isrec = app_isrec;
                    }

                    public String getPic() {
                        return pic;
                    }

                    public void setPic(String pic) {
                        this.pic = pic;
                    }

                    public String getTitle() {
                        return title;
                    }

                    public void setTitle(String title) {
                        this.title = title;
                    }

                    public double getPromotion_price() {
                        return promotion_price;
                    }

                    public void setPromotion_price(int promotion_price) {
                        this.promotion_price = promotion_price;
                    }

                    public double getPrice() {
                        return price;
                    }

                    public void setPrice(int price) {
                        this.price = price;
                    }

                    public String getIspost() {
                        return ispost;
                    }

                    public void setIspost(String ispost) {
                        this.ispost = ispost;
                    }

                    public int getIcon_top_left() {
                        return icon_top_left;
                    }

                    public void setIcon_top_left(int icon_top_left) {
                        this.icon_top_left = icon_top_left;
                    }

                    public String getSite() {
                        return site;
                    }

                    public void setSite(String site) {
                        this.site = site;
                    }

                    public String getDiscount() {
                        return discount;
                    }

                    public void setDiscount(String discount) {
                        this.discount = discount;
                    }

                    public String getVolume() {
                        return volume;
                    }

                    public void setVolume(String volume) {
                        this.volume = volume;
                    }

                    public String getApp_coupon_site() {
                        return app_coupon_site;
                    }

                    public void setApp_coupon_site(String app_coupon_site) {
                        this.app_coupon_site = app_coupon_site;
                    }

                    public String getPc_coupon_site() {
                        return pc_coupon_site;
                    }

                    public void setPc_coupon_site(String pc_coupon_site) {
                        this.pc_coupon_site = pc_coupon_site;
                    }

                    public String getShop_name() {
                        return shop_name;
                    }

                    public void setShop_name(String shop_name) {
                        this.shop_name = shop_name;
                    }
                }
            }
        }
    }
}
