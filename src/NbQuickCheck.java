import java.util.List;
import java.util.Map;

public class NbQuickCheck {

  /**
   * Performs a pre-order traversal of the tree, printing each node on a separate line.
   * Does nothing if the root is not present in the tree.
   *
   * @param tree the tree represented as a map of parent nodes to child lists
   * @param root the root node to start traversal from
   */
  public static void preOrder(Map<Integer, List<Integer>> tree, int root) {
    if(!tree.containsKey(root)) {
      return;
    }

    System.out.println(root);

    if (!tree.get(root).isEmpty()) {
      for (Integer num : tree.get(root)) {
        preOrder(tree, num);
      }
    }

  }

  /**
   * Returns the minimum value in the tree.
   * Returns Integer.MAX_VALUE if the root is null.
   *
   * @param root the root node of the tree
   * @return the minimum value in the tree or Integer.MAX_VALUE if root is null
   */
  public static int minVal(Node<Integer> root) {

    return helper(root, Integer.MAX_VALUE);

  }

  public static int helper(Node<Integer> root, int minValue) {

    if (root == null) return minValue;

    if (root.children.isEmpty()) return Math.min(minValue, root.value);

    if (root.value < minValue) {
      minValue = root.value;
    }

    for (Node<Integer> child : root.children) {
        minValue = Math.min(helper(child, minValue), minValue);
    }

    return minValue;

  }
  
}
