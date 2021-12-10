package statistics;

import statistics.matcher.*;

public class QueryBuilder {
    Matcher stack;

    public QueryBuilder() {
        this.stack = new All();
    }

    public QueryBuilder playsIn(String team) {
        this.stack = new And(new PlaysIn(team), this.stack);
        return this;
    }

    public QueryBuilder hasAtLeast(int amount, String matcher) {
        this.stack = new And(new HasAtLeast(amount, matcher), this.stack);
        return this;
    }

    public QueryBuilder hasFewerThan(int amount, String matcher) {
        this.stack = new And(new HasFewerThan(amount, matcher), this.stack);
        return this;
    }

    public QueryBuilder oneOf(Matcher... matchers) {
        this.stack = new Or(matchers);
        return this;
    }

    public Matcher build() {
        return this.stack;
    }
}
