# Bit Manipulation

This folder contains solutions to LeetCode problems that involve bit manipulation techniques.

## Common Concepts and Techniques

- Check if a number is even or odd: `(num & 1) == 0` for even numbers
- Get the i-th bit: `(num >> i) & 1`
- Set the i-th bit: `num | (1 << i)`
- Clear the i-th bit: `num & ~(1 << i)`
- Toggle the i-th bit: `num ^ (1 << i)`
- Count set bits (1s): `Integer.bitCount(num)` in Java

## Common Pitfalls

### Operator Precedence

In Java, the equality operator `==` has higher precedence than the bitwise AND operator `&`. This can lead to unexpected behavior:

