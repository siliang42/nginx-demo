-- ip集合
-- local remoteIps = {"-", "", "111.11.1, 222.2.2.2, abc.ddd", "127.0.01"}
local remoteIps = {ngx.var.real_ip, ngx.var.remote_addr}
-- 获取ip
function getRemoteIp(remoteIps)
    for i, v in ipairs(remoteIps) do
        if (v ~= nil and v ~= "-" and v ~= "")then
            return string.split(v, ',')[1];
        end
    end
end
--字符串切割
function string.split(input, delimiter)
    input = tostring(input)
    delimiter = tostring(delimiter)
    if (delimiter=='') then return false end
    local pos,arr = 0, {}
    for st,sp in function() return string.find(input, delimiter, pos, true) end do
        table.insert(arr, string.sub(input, pos, st - 1))
        pos = sp + 1
    end
    table.insert(arr, string.sub(input, pos))
    return arr
end

ngx.req.set_header("remote_addr", getRemoteIp(remoteIps))
