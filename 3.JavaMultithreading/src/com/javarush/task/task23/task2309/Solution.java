package com.javarush.task.task23.task2309;

import com.javarush.task.task23.task2309.vo.*;

import java.util.List;

/* 
Анонимность иногда так приятна!
*/

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        print(solution.getUsers());
        print(solution.getLocations());
        print(solution.getServers());
        print(solution.getSubjects());
        print(solution.getSubscriptions());
    }

    public List<User> getUsers() {
        AbstractDbSelectExecutor<User> user = new AbstractDbSelectExecutor<User>() {
            @Override
            public String getQuery() {
                return ("select * from " + "User").toUpperCase();
            }
        };
        return  user.execute();
    }

    public List<Location> getLocations() {
        AbstractDbSelectExecutor<Location> location = new AbstractDbSelectExecutor<Location>() {
            @Override
            public String getQuery() {
                return ("select * from " + "Location").toUpperCase();
            }
        };
        return  location.execute();
    }

    public List<Server> getServers() {
        AbstractDbSelectExecutor<Server> server = new AbstractDbSelectExecutor<Server>() {
            @Override
            public String getQuery() {
                return ("select * from " + "SERVER").toUpperCase();
            }
        };
        return  server.execute();
    }

    public List<Subject> getSubjects() {
        AbstractDbSelectExecutor<Subject> subject = new AbstractDbSelectExecutor<Subject>() {
            @Override
            public String getQuery() {
                return ("select * from " + "SUBJECT").toUpperCase();
            }
        };
        return  subject.execute();
    }

    public List<Subscription> getSubscriptions() {
        AbstractDbSelectExecutor<Subscription> subscription = new AbstractDbSelectExecutor<Subscription>() {
            @Override
            public String getQuery() {
                return ("select * from " + "SUBSCRIPTION").toUpperCase();
            }
        };
        return  subscription.execute();
    }

    public static void print(List list) {
        String format = "Id=%d, name='%s', description=%s";
        for (Object obj : list) {
            NamedItem item = (NamedItem) obj;
            System.out.println(String.format(format, item.getId(), item.getName(), item.getDescription()));
        }
    }
}
