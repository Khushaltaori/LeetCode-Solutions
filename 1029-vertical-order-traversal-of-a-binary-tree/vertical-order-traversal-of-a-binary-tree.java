class Solution {

    class Pair {
        int row;
        int val;

        Pair(int row, int val) {
            this.row = row;
            this.val = val;
        }
    }

    public List<List<Integer>> verticalTraversal(TreeNode root) {

        // column -> list of (row, value)
        TreeMap<Integer, List<Pair>> map = new TreeMap<>();

        dfs(root, 0, 0, map);

        List<List<Integer>> ans = new ArrayList<>();

        for (List<Pair> list : map.values()) {

            // Sort by row first, then value
            Collections.sort(list, (a, b) -> {
                if (a.row != b.row) {
                    return a.row - b.row;
                }
                return a.val - b.val;
            });

            List<Integer> column = new ArrayList<>();

            for (Pair p : list) {
                column.add(p.val);
            }

            ans.add(column);
        }

        return ans;
    }

    private void dfs(TreeNode node, int row, int col,
                     TreeMap<Integer, List<Pair>> map) {

        if (node == null) {
            return;
        }

        map.putIfAbsent(col, new ArrayList<>());
        map.get(col).add(new Pair(row, node.val));

        dfs(node.left, row + 1, col - 1, map);
        dfs(node.right, row + 1, col + 1, map);
    }
}