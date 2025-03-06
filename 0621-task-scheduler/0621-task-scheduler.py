class Solution:
    def leastInterval(self, tasks: List[str], n: int) -> int:
        frequencies = [0] * 26
        for task in tasks:
            frequencies[ord(task) - ord('A')] += 1
        frequencies.sort()
        frequencies[-1] -= 1
        total = frequencies[-1] * n
        maxFreq = frequencies.pop(25)
        for freq in frequencies:
            total -= min(maxFreq, freq)
        

        return total + len(tasks) if total > 0 else len(tasks)