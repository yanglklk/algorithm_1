package com.utils;

import org.apache.commons.lang.RandomStringUtils;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

public class TranserColumn {
    public static void main(String[] args) {
            TranserColumn.toValue();
            TranserColumn.toColumn();
    }
    public static void toColumn(){

        String s =
                "`company_uuid` varchar(100) NOT NULL COMMENT '公司uuid',`account_uuid` varchar(100) NOT NULL COMMENT '账户uuid',`mer_type` int(11) DEFAULT NULL COMMENT '商户类型',`mer_name` varchar(100) DEFAULT NULL COMMENT '商户简称',`mer_chan_no` varchar(100) DEFAULT NULL COMMENT '商户编号',`dept_uuid` varchar(100) DEFAULT NULL COMMENT '部门(加盟)表的uuid',`transaction_uuid` varchar(100) NOT NULL COMMENT '交易uuid',`tx_no` varchar(100) DEFAULT NULL COMMENT '交易编号',`tx_type_code` varchar(100) DEFAULT NULL COMMENT '交易性质',`property_uuid` varchar(100) DEFAULT NULL COMMENT '房源uuid',`whether_loan` int(11) DEFAULT NULL COMMENT '是否贷款',`tx_emp_uuid` varchar(100) DEFAULT NULL COMMENT '交易归属人uuid',`tx_dept_uuid` varchar(100) DEFAULT NULL COMMENT '交易归属部门uuid',`subscribe_date` datetime DEFAULT NULL COMMENT '认购日期',`earnest_date` datetime DEFAULT NULL COMMENT '转定日期',`signing_date` datetime DEFAULT NULL COMMENT '签约日期',`change_house_date` datetime DEFAULT NULL COMMENT '过户日期',`receipt_category_uuid` varchar(100) DEFAULT NULL COMMENT '费用类型',`prorateable` int(11) DEFAULT NULL COMMENT '是否分账',`order_uuid` varchar(100) NOT NULL COMMENT '分账uuid',`order_type` int(11) DEFAULT NULL COMMENT '收支类型',`order_type_detail` int(11) DEFAULT NULL COMMENT '子订单类型',`order_amount` decimal(19,2) DEFAULT NULL COMMENT '收支金额',`management_amount` decimal(19,2) DEFAULT NULL COMMENT '分账金额(管理费)',`cost_amount` decimal(19,2) DEFAULT NULL COMMENT '成本',`rebate_amount` decimal(19,2) DEFAULT NULL COMMENT '返佣(应付收入)',`service_amount` decimal(19,2) DEFAULT NULL COMMENT '手续费',`sub_create_date` datetime DEFAULT NULL COMMENT '分账记录创建日期',`sub_type` int(11) DEFAULT NULL COMMENT '是否分账(计算版) 0-分账 1-非分账',`flowuuid` varchar(100) NOT NULL COMMENT '分账日志uuid',`receive_account_uuid` varchar(100) DEFAULT NULL COMMENT '收款账户uuid',`payment_account_uuid` varchar(100) DEFAULT NULL COMMENT '付款账户uuid',`property_name` varchar(200) DEFAULT NULL COMMENT '拼接的房源名称'";
        String[] ss = s.split(",`");
        StringBuffer columns = new StringBuffer("(");
        for (int i = 0; i < ss.length; i++) {
            int indexL = i == 0 ? 1 : 0;
            int indexR = ss[i].lastIndexOf('`');
            String columnName = ss[i].substring(indexL, indexR);
            columns.append(columnName+",");
            StringBuffer sb = new StringBuffer();
            sb.append(columnName.toUpperCase() + "(\"" + columnName + "\", \"");
            indexL = ss[i].indexOf("'");
            indexR = ss[i].lastIndexOf("'");
            if (indexL > 0 && indexR > 0) {
                String comment = ss[i].substring(indexL + 1, indexR);
                sb.append(comment + "\"),");
                System.out.println(sb.toString());
            }
        }
        columns.deleteCharAt(columns.length()-1);
        columns.append(")");
        System.out.println("---------");
        System.out.println(columns);
    }

    public static void toValue() {

//        String s =
//                "`company_uuid` varchar(100) NOT NULL COMMENT '公司uuid',`account_uuid` varchar(100) NOT NULL COMMENT '账户uuid',`mer_type` int(11) DEFAULT NULL COMMENT '商户类型',`mer_name` varchar(100) DEFAULT NULL COMMENT '商户简称',`mer_chan_no` varchar(100) DEFAULT NULL COMMENT '商户编号',`dept_uuid` varchar(100) DEFAULT NULL COMMENT '部门(加盟)表的uuid',`transaction_uuid` varchar(100) NOT NULL COMMENT '交易uuid',`tx_no` varchar(100) DEFAULT NULL COMMENT '交易编号',`tx_type_code` varchar(100) DEFAULT NULL COMMENT '交易性质',`property_uuid` varchar(100) DEFAULT NULL COMMENT '房源uuid',`whether_loan` int(11) DEFAULT NULL COMMENT '是否贷款',`tx_emp_uuid` varchar(100) DEFAULT NULL COMMENT '交易归属人uuid',`tx_dept_uuid` varchar(100) DEFAULT NULL COMMENT '交易归属部门uuid',`subscribe_date` datetime DEFAULT NULL COMMENT '认购日期',`earnest_date` datetime DEFAULT NULL COMMENT '转定日期',`signing_date` datetime DEFAULT NULL COMMENT '签约日期',`change_house_date` datetime DEFAULT NULL COMMENT '过户日期',`receipt_category_uuid` varchar(100) DEFAULT NULL COMMENT '费用类型',`prorateable` int(11) DEFAULT NULL COMMENT '是否分账',`order_uuid` varchar(100) NOT NULL COMMENT '分账uuid',`order_type` int(11) DEFAULT NULL COMMENT '收支类型',`order_type_detail` int(11) DEFAULT NULL COMMENT '子订单类型',`order_amount` decimal(19,2) DEFAULT NULL COMMENT '收支金额',`management_amount` decimal(19,2) DEFAULT NULL COMMENT '分账金额(管理费)',`cost_amount` decimal(19,2) DEFAULT NULL COMMENT '成本',`rebate_amount` decimal(19,2) DEFAULT NULL COMMENT '返佣(应付收入)',`service_amount` decimal(19,2) DEFAULT NULL COMMENT '手续费',`sub_create_date` datetime DEFAULT NULL COMMENT '分账记录创建日期',`sub_type` int(11) DEFAULT NULL COMMENT '是否分账(计算版) 0-分账 1-非分账',`flowuuid` varchar(100) NOT NULL COMMENT '分账日志uuid',`receive_account_uuid` varchar(100) DEFAULT NULL COMMENT '收款账户uuid',`payment_account_uuid` varchar(100) DEFAULT NULL COMMENT '付款账户uuid',`property_name` varchar(200) DEFAULT NULL COMMENT '拼接的房源名称'";
        String s = "";

        String[] ss = s.split(",`");

        int count = 10;
        for (int j = count; j > 0; j--) {
            Random random = new Random();
            StringBuffer sb = new StringBuffer("(");
            for (int i = 0; i < ss.length; i++) {
                int indexL = ss[i].lastIndexOf('`')+2;
                String sub =ss[i].substring(indexL,indexL+3);
                if ("big".equals(sub)){
                    Integer  ii = random.nextInt(7);
                    sb.append(ii+",");
                }else if ("var".equals(sub)){
                    String sss = RandomStringUtils.randomAlphanumeric(15);
                    sb.append("\'"+sss+"\',");
                }
                else if ("tim".equals(sub)){
                    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                    Date date = new Date(random.nextLong()%1636621930);
                    String datef = sdf.format(date);
                    sb.append("\'"+datef+"\',");
                }
                else if ("dec".equals(sub)){
                    BigDecimal bigDecimal = new BigDecimal(random.nextDouble());
                    bigDecimal = bigDecimal.setScale(2, RoundingMode.DOWN);
                    sb.append(bigDecimal+",");
                }
                else if ("tin".equals(sub)){
                    Integer ii = 1;
                    sb.append(ii+",");
                }
            }
            sb.deleteCharAt(sb.length()-1);
            sb.append("),");
            System.out.println(sb.toString());
        }

    }
}

