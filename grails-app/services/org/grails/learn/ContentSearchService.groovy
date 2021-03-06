package org.grails.learn
import org.compass.core.engine.SearchEngineQueryParseException

class ContentSearchService {

    def search(Class type, String q, offset) {
        if (q) {
            try {
                def searchResult = type.search(q, offset: offset)
                return searchResult?.results
            }
            catch (SearchEngineQueryParseException ex) {
                return []
            }
            catch (org.apache.lucene.search.BooleanQuery.TooManyClauses ex) {
                return []
            }
        }
        else {
            return []
        }
    }
}
