class Solution {
public:
    vector<string> ans;

    unordered_map<char, string> mp = {
        {'2', "abc"},
        {'3', "def"},
        {'4', "ghi"},
        {'5', "jkl"},
        {'6', "mno"},
        {'7', "pqrs"},
        {'8', "tuv"},
        {'9', "wxyz"}
    };

    void backtrack(string &digits, int index, string &curr) {

        if (index == digits.size()) {
            ans.push_back(curr);
            return;
        }

        string letters = mp[digits[index]];

        for (char ch : letters) {
            curr.push_back(ch);
            backtrack(digits, index + 1, curr);
            curr.pop_back();        // Backtrack
        }
    }

    vector<string> letterCombinations(string digits) {

        if (digits.empty())
            return {};

        string curr = "";
        backtrack(digits, 0, curr);

        return ans;
    }
};
