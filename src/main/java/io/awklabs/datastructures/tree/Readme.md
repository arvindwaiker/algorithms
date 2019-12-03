Trees

Each node can be linked to 2 other nodes.

1. Given level starts at 1, The Maximum number of node at a level is ( 2 ^ (i -1))
2. Given single node tree has a height 1, The maximum number of nodes in a tree with height 'h' is 2^h - 1.

Types of Binary Trees
1. Full Binary Tree : Every node has 0 or 2 nodes. All the nodes except leaves have 2 child nodes.
2. Complete Binary Tree : All the levels are full except for the last level and the nodes are getting filled from left to right.
3. Perfect Binary Tree : All the nodes are full with 2 nodes, and all the leaves are at the same level.
4. Balanced Binary Tress : A binary tree is balanced if the height of the left sub tree and right sub tree only differ by 1.
    1. https://leetcode.com/problems/balanced-binary-tree/
5. Binary Search Tree, is a node-based binary tree data structure which has the following properties:
   1. The left subtree of a node contains only nodes with keys lesser than the node’s key.
   2. The right subtree of a node contains only nodes with keys greater than the node’s key.
   3. The left and right subtree each must also be a binary search tree.
   4. There must be no duplicate nodes.
6. AVL Tree : Is a Binary Search Tree that is self balancing. Every insert and delete triggers a logic to rebalance itself.
    1. Left Rotate
    2. Right Rotate   
   
Heaps

1. Max Heap : Root is the highest value. Child have the lowest value.
2. Min Heap : Root is the lowest value. Child have the highest value.

