package larpo.deals

import org.grails.buffer.StreamCharBuffer

import java.text.SimpleDateFormat

class DateFormatTagLib
{
    static defaultEncodeAs = [taglib:'html']
    //static encodeAsForTags = [tagName: [taglib:'html'], otherTagName: [taglib:'none']]

    def dateformat = { attrs, body ->
        out << new Date().parse("yyyy-MM-dd HH:mm", body().toString()).format("dd/MM/yyy HH:mm")
    }
}