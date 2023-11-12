class Solution {
    fun numBusesToDestination(routes: Array<IntArray>, source: Int, target: Int): Int {
        if (source == target) {
            return 0
        }
        val adjList = HashMap<Int, ArrayList<Int>>()
        for (r in routes.indices) {
            for (stop in routes[r]) {
                val route = adjList.getOrDefault(stop, ArrayList())
                route.add(r)
                adjList[stop] = route
            }
        }
        val q: Queue<Int> = LinkedList()
        val vis: MutableSet<Int> = HashSet(routes.size)
        for (route in adjList[source]!!) {
            q.add(route)
            vis.add(route)
        }
        var busCount = 1
        while (!q.isEmpty()) {
            val size = q.size
            for (i in 0 until size) {
                val route = q.remove()
                for (stop in routes[route]) {
                    if (stop == target) {
                        return busCount
                    }
                    for (nextRoute in adjList[stop]!!) {
                        if (!vis.contains(nextRoute)) {
                            vis.add(nextRoute)
                            q.add(nextRoute)
                        }
                    }
                }
            }
            busCount++
        }
        return -1
    }
}