package br.com.mhbp.graph.dfs;

import java.util.*;

public class MatchResultDFS {

    static class MatchResult {
        String winningTeam;
        String losingTeam;

        public MatchResult(String winningTeam, String losingTeam) {
            this.winningTeam = winningTeam;
            this.losingTeam = losingTeam;
        }
    }


    static boolean canTeamABeatTeamB(List<MatchResult> results, String teamA, String teamB) {

        return isReachable(buildGraph(results), teamA, teamB, new HashSet<>());
    }

    private static boolean isReachable(Map<String, List<String>> graph, String teamA, String teamB, HashSet<String> visited) {

        if (teamA.equals(teamB)) return true;
        else if (visited.contains(teamA) || graph.get(teamA) == null ) return false;

        visited.add(teamA);
        List<String> matchResults = graph.get(teamA);

        for (String losingTeam : matchResults) {
            if (isReachable(graph, losingTeam, teamB, visited)) return true;
        }

        return false;
    }

    private static Map<String, List<String>> buildGraph(List<MatchResult> results) {
        Map<String, List<String>> map = new HashMap<>();
        for (MatchResult mr : results) map.putIfAbsent(mr.winningTeam, new ArrayList<>()).add(mr.losingTeam);
        return map;
    }
}
