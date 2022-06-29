package wq.cdm.top.springbootdemos.dao.language_dirver;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.ibatis.mapping.SqlSource;
import org.apache.ibatis.scripting.xmltags.XMLLanguageDriver;
import org.apache.ibatis.session.Configuration;

/**
 * @author wuqiao <wuqiao@kuaishou.com>
 * Created on 2022-06-29
 */
public class CollectionDriver extends XMLLanguageDriver {
    private final Pattern pattern = Pattern.compile("\\(#\\{(\\w+)\\}\\)");
    @Override
    public SqlSource createSqlSource(Configuration configuration, String script, Class<?> parameterType) {
        Matcher matcher = pattern.matcher(script);
        if (matcher.find()) {
            String forEach = "<foreach item=\"_item\" collection=\"$1\" open=\"(\" separator=\",\" close=\")"
                    + "\">#{_item}</foreach>";
            script = matcher.replaceAll(forEach);
        }
        script = "<script>" + script + "</script>";

        return super.createSqlSource(configuration, script, parameterType);
    }
}
